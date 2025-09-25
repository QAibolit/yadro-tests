
# Проект по автоматизации тестирования сайта [Yadro](https://yadro.com/)  


## **Содержание:**

* [Технологии и инструменты](#технологии-и-инструменты)

* [Реализованные проверки](#реализованные-проверки)

* [Запуск из терминала](#запуск-из-терминала)

* [Сборка в Jenkins](#сборка-в-jenkins)

* [Allure отчет](#allure-отчет)

* [Интеграция с Allure TestOps](#интеграция-с-allure-testops)

* [Интеграция с Jira](#интеграция-с-jira)

* [Уведомление в Telegram при помощи бота](#уведомление-в-telegram-при-помощи-бота)

* [Примеры видео выполнения тестов на Selenoid](#примеры-видео-выполнения-тестов-на-selenoid)  

---
## :star: Технологии и инструменты:  

<p>
<img width="45" alt="IntelliJ IDEA" src="media/icons/Idea.svg">
<img width="45" alt="Java" src="media/icons/java.svg">
<img width="45" alt="JUnit5" src="media/icons/Junit5.svg">
<img width="45" alt="Selenide" src="media/icons/Selenide.svg">
<img width="45" alt="Allure" src="media/icons/Allure.svg">
<img width="45" alt="Gradle" src="media/icons/gradle-original.svg">
<img width="45" alt="Jenkins" src="media/icons/jenkins.svg">
<img width="45" alt="Selenoid" src="media/icons/Selenoid.svg">
<img width="45" alt="Selenoid" src="media/icons/Allure_TO.svg">
<img width="45" alt="Selenoid" src="media/icons/jira.svg">
</p>  

---
## :open_file_folder: Реализованные проверки:  

- Проверка работы кнопок меню: "Продукты", "Партнеры", "Сервис", "О нас", "Вакансии"
- Проверка контента главной страницы: кнопка продукта, кнопка информации о компании  

---
## :computer: Запуск из терминала:  

<p>Команда для запуска тестов из терминала на удаленном браузере:</p>

```
./gradlew clean ${task} -DremoteUrl=${selenoidUrl}
```

Где: 
- ${task} - название таски, которую вы хотите запустить (test, regress). Таски можно настроить по тегу в файле build.gradle
- ${selenoidUrl} - URL вашего селеноида

Так же можно добавлять параметры:
- `-Dbrowser=название_браузера` - устанавливает браузер, в котором будут запускаться тесты. По умолчанию установлен chrome.
- `-DbrowserVersion=версия_браузера` - устанавливает версию браузера. По умолчанию установлена версия 128 для chrome.
- `-DbrowserSize=ширина x высота` - устанавливает размер окна браузера. По умолчанию задан размер браузера "1920x1080".
- `-Dtimeout=таймаут` - устанавливает таймаут. По умолчанию установлен таймаут 10000 мс.

Команда для локального запуска тестов(без использования селеноида):

```
./gradlew clean ${task} -DisRemote=false
```
Где:
- ${task} - название таски, которую вы хотите запустить (test, regress)
- `-DisRemote=false` - параметр устанавливает значение isRemote как false и при запуске используется локальный браузер. По умолчанию isRemote равен true

---
## <img width="25" alt="Jenkins" src="media/icons/jenkins.svg"> Сборка в Jenkins:  

<img alt="Сборка в Jenkins" src="media/images/jenkins.png">  

---
## <img width="25" alt="Allure" src="media/icons/Allure.svg"> Allure отчет:  

**Overview:**

<img alt="Allure отчет" src="media/images/allure.png">

**Tests:**

<img alt="Allure отчет: тесты" src="media/images/allure-tests.png">  

---
## <img width="25" alt="AllureTestOps" src="media/icons/Allure_TO.svg"> Интеграция с Allure TestOps:  

**Тест-кейсы:**

<img alt="Интеграция с Allure TestOps" src="media/images/AllureTestOps.png">

**Dashboard прогонов:**

<img alt="Интеграция с Allure TestOps: прогоны" src="media/images/AllureTestOps-прогоны.png">  

---
## <img width="25" alt="Jira" src="media/icons/jira.svg"> Интеграция AllureTestOps с Jira:  

<img alt="Интеграция с Jira" src="media/images/jira.png">  

---
## <img width="25" alt="telegram" src="media/icons/telegram.svg"> Уведомление в Telegram при помощи бота:  

<img alt="Интеграция с Jira" src="media/images/telegram.png">  

---
## <img width="25" alt="Selenoid" src="media/icons/Selenoid.svg"> Примеры видео выполнения тестов на Selenoid:  

<img alt="Selenoid video" src="media/gifs/selenoid-video.gif"> 