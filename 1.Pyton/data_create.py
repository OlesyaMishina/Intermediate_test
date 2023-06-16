# def datetime():
#     datetime=
#     return datetime

import os

file_name = 'data.csv'

def id_data():
    
    if os.path.exists(file_name):
        with open(file_name, 'r', encoding='utf-8') as file:
            id=int(file.readlines()[-1].split(';')[0])+1
    else:
        id=1
    return id


def id_update():
    if os.path.exists(file_name):
        count=1
        new_list_data = []
        with open(file_name, 'r', encoding='utf-8') as file:
            list_data = file.readlines()
            for element in list_data:
                note=element.split(';')
                print(note)
                note[0]=count
                new_list_data.append(note)
                print(new_list_data)
                count=count+1
    else:
        print("Файл не существует.")            


def title_data():
    title = input("Введите заголовок записи: ")
    return title


def body_data():
    body = input("Введите содержание записи: ")
    return body


