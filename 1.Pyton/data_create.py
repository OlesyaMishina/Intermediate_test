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


          


def title_data():
    title = input("Введите заголовок записи: ")
    return title


def body_data():
    body = input("Введите содержание записи: ")
    return body


