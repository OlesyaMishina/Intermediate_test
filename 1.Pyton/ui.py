from logger import input_data, print_data, filter_data, delete_data, replace_data


def interface():
   
    print("""Выберите режим работы:
             1 - добавление записи
             2 - вывод всех данных
             3 - поиск данных
             4 - удаление данных
             5 - замена данных
             6 - выход из программы
             """)
    command_number = int(input("Введите номер комманды: "))
    while command_number!=6:
        while command_number < 1 or command_number > 6:
            print("Введите корректный номер комманды:")
            command_number = int(input("Введите номер комманды: "))

        if command_number == 1:
            input_data()
        elif command_number == 2:
            print_data()
        elif command_number == 3:
            print("Введите искомую информацию (подстроку): ")
            filter_string = input()
            filter_data(filter_string)
        elif command_number == 4:
            print("Введите параметры для удаления данных: id или заголовок ")
            delete_string = input()
            delete_data(delete_string)
        elif command_number == 5:
            find_id = int(input("Введите id изменяемой записи: "))
            replace_data(find_id)
        print("""Выберите режим работы:
             1 - добавление записи
             2 - вывод всех данных
             3 - посик данных
             4 - удаление данных
             5 - замена данных
             6 - выход из программы
             """)
        command_number = int(input("Введите номер комманды: "))
    print("Вы вышли из программы.")
        
