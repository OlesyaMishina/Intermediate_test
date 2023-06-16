
import os
import datetime
from data_create import id_data, title_data, body_data

file_name = 'data.csv'
dt_now = datetime.datetime.now().replace(microsecond=0)

def print_data():
    if os.path.exists(file_name):
        print("Вывoд данных из файла: ")
        with open(file_name, 'r', encoding='utf-8') as file:
            list_data = file.readlines()
            for element in list_data:
                print(element)
    else:
        print("Файл не существует.")


def input_data():
    print("Введите данные для добавления в файл: ")
    id = id_data()
    title = title_data()
    body = body_data()
    with open(file_name, 'a', encoding='utf-8') as file:
        file.write(f'{id}; {dt_now}; {title}; {body}\n')
        print(f'Запись добавлена.')



