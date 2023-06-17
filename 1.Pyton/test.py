import datetime
import os
line_db='2011-11-04'

file_name = 'data.csv'
# line_db2='2011-11-05'
# line_db3='2011-11-04'
# data=datetime.datetime.fromisoformat(line_db).replace(microsecond=0)
# if line_db==line_db3:
#     print('р+да')
# else:
#     print('нет')
print("Введите дату в формате гггг-мм-дд:")
data=input()
find_data=datetime.datetime.fromisoformat(data)
with open(file_name, 'r', encoding='utf-8') as file:
        list_data = file.readlines()
        for element in list_data:
            is_found = False
            temp=datetime.datetime.fromisoformat(element.split('; ')[1].split(' ')[0] )
            # print(temp.date())  
            # print(find_data.date())
            if temp.date()==find_data.date():
                   is_found = True
                   print(element)
        if not is_found:
            print("Записей с такой датой не существует.")           






