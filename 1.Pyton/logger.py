import os
import datetime
from data_create import id_data, title_data, body_data

file_name = 'data.csv'
dt_now = datetime.datetime.now().replace(microsecond=0)

# функция вывоа данных в консоль
def print_data():
    if os.path.exists(file_name):
        print("Вывoд данных из файла: ")
        with open(file_name, 'r', encoding='utf-8') as file:
            list_data = file.readlines()
            for element in list_data:
                print(element)
    else:
        print("Файл не существует.")

# Функция добавления записи
def input_data():
    print("Введите данные для добавления в файл: ")
    id = id_data()
    title = title_data()
    body = body_data()
    with open(file_name, 'a', encoding='utf-8') as file:
        file.write(f'{id}; {dt_now}; {title}; {body}\n')
        print(f'Запись добавлена.')

# Функция удаления данных по id или названию записи
def delete_data(delete_string):
    with open(file_name, 'r', encoding='utf-8') as file:
        list_data = file.readlines()
        is_found = False
        output_data = []
        for element in list_data:
            output_data.append(element)
            temp_record = element.split('; ')
            for record in temp_record:
                if delete_string.lower() == record.lower():
                    print(
                        f"Вы точно хотите удалить запись {temp_record}? \nВведите да - подтвердить удаление, нет - отменить удаление.")
                    if input().lower() == "да".lower():
                        output_data.remove(element)
                        is_found = True
                        print(f"Запись {temp_record} удалена.\n")                   

        if not is_found:
            print("Таких засисей нет. ")
        else: 
            # перезаписываем id
            count=1
            new_output_data=[]
            for element in output_data:
                note=element.split(';')
                note[0]=str(count)
                str_note=note[0]+";"+note[1]+";"+note[2]+";"+note[3]
                new_output_data.append(str_note)
                count=count+1
            with open(file_name, 'w', encoding='utf-8') as file:
                for line in new_output_data:
                    file.write(line)
              
# Функция поиска данных по подстроке
def filter_data(filter_string):
    with open(file_name, 'r', encoding='utf-8') as file:
        list_data = file.readlines()
        is_found = False
        for element in list_data:
            if filter_string.lower() in element.lower():
                print(element)
                is_found = True
    if not is_found:
        print("Таких записей нет. ")





