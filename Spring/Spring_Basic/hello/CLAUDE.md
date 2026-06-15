# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Commands

Run from `SpringBoot_RoadMap/Spring/Spring_Basic/hello/` (use `.\gradlew` on Windows):

```bash
.\gradlew build                                                                  # build
.\gradlew bootRun                                                                # run (default port 8080)
.\gradlew test                                                                   # run all tests
.\gradlew test --tests "hello.core.member.MemberServiceTest"                    # run single test class
.\gradlew test --tests "hello.core.discount.RateDiscountPolicyTest.vip_o"       # run single test method
```

Stack: Spring Boot 4.0.6, Java 19, JUnit 5.

## Architecture

Source lives under `src/main/java/hello/core/`.

```
HelloApplication.java       # Spring Boot entry point
AppConfig.java              # @Configuration — explicit bean wiring (constructor injection)
MemberApp.java              # Main method demo for member domain
OrderApp.java               # Main method demo for order domain
member/
  Grade.java                # Enum: BASIC, VIP
  Member.java               # Entity: id (Long), name, grade
  MemberRepository.java     # Interface: save, findById
  MemoryMemberRepository.java  # In-memory HashMap implementation
  MemberService.java        # Interface: join, findMember
  MemberServiceImpl.java    # Constructor-injected with MemberRepository
discount/
  DiscountPolicy.java       # Interface: discount(member, price)
  FixDiscountPolicy.java    # Fixed amount discount
  RateDiscountPolicy.java   # 10% rate discount for VIP (currently active)
order/
  Order.java                # Value object: memberId, itemName, itemPrice, discountPrice
  OrderService.java         # Interface: createOrder
  OrderServiceImpl.java     # Constructor-injected with MemberRepository + DiscountPolicy
```

## Key Design Pattern

**All DI wiring lives in `AppConfig.java`** — no `@ComponentScan` or `@Autowired` anywhere. This is intentional: the project studies how Spring DI works by wiring everything explicitly with `@Bean` methods.

To swap the discount strategy (OCP/DIP demonstration), change only `AppConfig.discountPolicy()` — currently returns `RateDiscountPolicy`, can be switched to `FixDiscountPolicy` without touching any other class.

## Test Pattern

Tests instantiate `AppConfig` directly in `@BeforeEach` — no Spring `ApplicationContext` is loaded:

```java
@BeforeEach
public void beforeEach() {
    AppConfig appConfig = new AppConfig();
    memberService = appConfig.memberService();
}
```

`MemoryMemberRepository` uses a plain `HashMap` (not static), so there is no shared state bleed between tests.