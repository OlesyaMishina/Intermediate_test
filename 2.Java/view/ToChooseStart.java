package view;

public class ToChooseStart {
    public int toChoose() {
        ToReadAnswer answer=new ToReadAnswer();
        System.out.println("\n1 - Загрузить список доступных игрушек из файла\n" +
                "2 - Распечатать список доступных игрушек\n" +
                "3 - Добавить игрушку в список доступных игрушек\n" +
                "4 - Запустить розыгрыш призовой игрушки\n" +
                "5 - Распечатать список призовых игрушек\n" +
                "6 - Сохрянить список доступных игрушек в файл\n" +
                "7 - завершить работу.");
        return answer.readAnswer();
    }
}
