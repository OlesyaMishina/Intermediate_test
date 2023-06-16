import datetime
import os

from data_create import body_data, title_data


file_name = 'data.csv'
dt_now = datetime.datetime.now().replace(microsecond=0)

# Функция редактирования записи
def replace_data(find_id):
    
    with open(file_name, 'r', encoding='utf-8') as file:
        list_data = file.readlines()
        is_found =False
        output_data =[]
        for i in range(len(list_data)):
            output_data.append(list_data[i])
            id = int(list_data[i].split('; ')[0])
            if id == find_id:
                is_found=True
                print(f"Вы точно хотите изменить запись: {list_data[i]}\nВведите да - подтвердить замену, нет - отменить")
                if input().lower() == "да".lower():
                    output_data.remove(list_data[i])
                    title=title_data()
                    body=body_data()
                    output_str=str(id) +'; '+ str(dt_now)+'; '+title+'; '+ body+'\n'
                    output_data.append(output_str)
            
        if not is_found:
            print("Записи с таким id не существует. ")

        else:
            with open(file_name, 'w', encoding='utf-8') as file:
                for line in output_data:
                    file.write(line)

                    
replace_data(5)