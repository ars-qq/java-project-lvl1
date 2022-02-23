install: # очистка + установка
	./gradlew clean install

run-dist: #запуск исполняемого файла
	./build/install/app/bin/app

check-updates: #проверка обновлений зависимостей и плагинов
	./gradlew dependencyUpdates
