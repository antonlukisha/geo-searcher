Места (Асинхронное сетевое взаимодействие)
Используя методы асинхронного программирования (например, CompletableFuture для Java) или библиотеки реактивного программирования (RxJava, например) провзаимодействовать с несколькими публично доступными API и сделать приложение с любым интерфейсом, основанное на этих API. При этом API должны использоваться так:

Все вызовы должны делаться с помощью HTTP-библиотеки с асинхронных интерфейсом;
Все независимые друг от друга вызовы API должны работать одновременно;
Вызовы API, которые зависят от данных, полученных из предыдущих API, должны оформляться в виде асинхронной цепочки вызовов;
Все результаты работы должны собираться в общий объект, поэтапный вывод результатов в процессе работы недопустим;
Не допускаются блокировки на ожидании промежуточных результатов в цепочке вызовов, допустима только блокировка на ожидании конечного результата (в случае консольного приложения).
Другими словами, логика программы должна быть оформлена как две функции, каждая из которых возвращает CompletableFuture (или аналог в вашем ЯП) без блокировок. Первая функция выполняет п.2, а вторая — п.п. 4 и 5 из списка ниже.
