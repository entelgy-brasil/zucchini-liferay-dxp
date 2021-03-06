# Zucchini for Liferay DXP

Zucchini extension for Liferay DXP

## Usage

```xml
<dependency>
    <groupId>br.com.entelgy</groupId>
    <artifactId>zucchini-liferay-dxp</artifactId>
    <version>1.0.0</version>
    <scope>test</scope>
</dependency>

```
### Configuration

[https://entelgy-brasil.github.io/zucchini/](https://entelgy-brasil.github.io/zucchini/)

### Example

```cucumber
#language: en
@it
Feature: Navigate to public home

Scenario:  Navigate to public home with a logged User
  Given user "test@liferay.com" and password "test" is logged in liferay
    Then I navigate to "web/guest/home"
    Then element having id "portlet-id" should be present
    Then I logout in liferay
```

## Steps

### Liferay Steps

* Given user Test is logged in liferay
* Given user "{email}" and password "{password}" is logged in liferay
* Then I log in as Test in liferay
* Then I log in as "{email}" and password "{password}" in liferay
* Then I logout in liferay
