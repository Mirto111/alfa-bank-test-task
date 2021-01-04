##### Сервис, который обращается к сервису курсов валют, и отдает gif в ответ:
Примечание 
1. Сервис с которого мы берем курсы валют (https://openexchangerates.org) для бесплатного аккаунта 
предоставляет довольно ограниченный функционал. Для кода валюты мы может использовать только USD,
при попытке использовать другие коды будет выскакивать ошибка ограничения доступа. Это можно исправить заменив
apiKey в проперти файле на другой с расширенными возможностями  
2. Хотя в задании не описан такой вариант, но сервис openexchangerates может возвращать одинаковые курсы валют
для текущего и предыдущего дня (например с 1 по 2 января курс не менялся) в таком случае возвращается сообщение
"Курс не изменился" 

###### Доступные методы:          
* GET /api/rate/{code}   ,code - это трехбуквенный код валюты(например, USD)
###### Описание
Если курс больше или меньше вчерашнего возвращает url-адрес gif с сайта https://giphy.com, 
а если курсы равны - возвращает строку что курс не изменился

##### Сборка приложения
Команды нужно выполнять из корня проекта

<p>./gradlew bootJar - собирает проект в jar файл </p>
<p>./gradlew bootRun - запуск проекта</p>
Сервис будет доступен на localhost:8080 (пример http://localhost:8080/api/rate/USD)
<h6>Команды для создания docker-контейнера и его запуска</h6>
<p>docker build -t alfa-bank-test-task .</p>
<p>docker run --name alfabank-test -p 8080:8080 -t alfa-bank-test-task</p>


