import os

file_name = 'data.csv'

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
                file.write('\n')    

delete_data('Первая запись')