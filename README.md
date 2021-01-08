Реализовать интерфейс Terminal, с помощью которого можно: Проверить состояние счета, Снять/Положить деньги

Доступ к терминалу (терминал для одного счета) предоставляется только после ввода корректного пин-кода (4 цифры). 
Каждое нажатие должно восприниматься системой как ввод очередного символа пин-кода.
При вводе нецифрового символа система должна выдать предупреждение, но при этом данное
действие не считается критичной ошибкой ввода и состояние системы должно восстановиться
к последнему корректному состоянию.
При вводе 3 неправильных пин-кодов аккаунт блокируется на 10 сек (при попытке обратиться к нему в течение этого времени должно вызываться исключение AccountIsLockedException
c информацией об оставшемся времени до снятия блокировки). Класть и снимать деньги можно только, если сумма кратна 100.

Этот репозиторий представляет собой простой пример того, как могли бы быть реализованы поставленые задачи.
Есть банкомат (ATM) в котором выполняется программа Terminal, совместно с PinValidator.
Банкомат обменивается данными с другой программой - TerminalSeriver, которая находится удаленно.
TerminalSeriver имеет доступ к базе счетов клиентов банка (в моем примере это один класс Bill)
Пользователь банкомата вставляет ключ-карту для идентификации и вводит пинкод. 
Запрос отправляется через Terminal на TerminalSeriver.
Если пинкод верен, пользователь получает доступ к счету, соотвествующему вставленной ключ-карте.
Когда доступ к счету получен, пользователь может совершать валютные операцие, соотвествующие условиям задачи.

Точка входа: Task5SberTech/blob/master/_ATM/_Terminal/src/main/java/com/school1/Main.java

## UML diagrams

You can render UML diagrams using [Mermaid](https://mermaidjs.github.io/). For example, this will produce a sequence diagram:

```mermaid
sequenceDiagram
Alice ->> Bob: Hello Bob, how are you?
Bob-->>John: How about you John?
Bob--x Alice: I am good thanks!
Bob-x John: I am good thanks!
Note right of John: Bob thinks a long<br/>long time, so long<br/>that the text does<br/>not fit on a row.

Bob-->Alice: Checking with John...
Alice->John: Yes... John, how are you?
```

And this will produce a flow chart:

```mermaid
graph LR
A[Square Rect] -- Link text --> B((Circle))
A --> C(Round Rect)
B --> D{Rhombus}
C --> D
```
