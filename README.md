# Spring Boot Microservices Infrastructure

A foundational infrastructure component library for Spring Boot microservices development.

## Installation

### Maven Usage

- Step1: Add the dependency to your `pom.xml`.

```xml
<dependency>
    <groupId>com.arminzheng</groupId>
    <artifactId>infrastructure</artifactId>
    <version>0.0.1</version>
</dependency>
```

- Step2: Add the repository configuration.

```xml
<repository>
    <id>infrastructure</id>
    <url>https://www.arminzheng.com/repository/</url>
</repository>
```

#### Maven Mirror Configuration

When using custom Maven settings (~/.m2/settings.xml), ensure mirrors are configured properly:

- Avoid ❌ `<mirrorOf>*</mirrorOf>`
- Replace with ✅ `<mirrorOf>central</mirrorOf>`

> The options of `<mirrorOf>` can be used to specify the scope of the mirror image

### Gradle Usage

- Step1: Add the dependency to your `build.gradle`.

```groovy
implementation 'com.arminzheng:infrastructure:0.0.1'
```

- Step2: Add the `repositories` configuration.

```groovy
repositories {
  maven {
    url = uri('https://www.arminzheng.com/repository')
  }
}
```

---
(END)
