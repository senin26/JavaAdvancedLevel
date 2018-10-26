public enum DayOfWeek {

    MONDAY("Понедельник", 40), TUESDAY("Вторник", 32), WEDNESDAY("Среда", 24),
    THURSDAY("Четверг", 16), FRIDAY("Пятница", 8), SATURDAY("Суббота", 0), SUNDAY("Воскресенье", 0);

    private String rusName;
    private int workingHours;

    DayOfWeek(String rusName, int workingDaysLeft) {
        this.rusName = rusName;
        this.workingHours = workingDaysLeft;
    }


    public int getWorkingHours() {
        return workingHours;
    }

    public String getRusName() {
        return rusName;
    }
}

class Main {

    public static void main(String[] args) {

        for (DayOfWeek eachDay : DayOfWeek.values()) {
            if (eachDay.getRusName().equals("Вторник") || eachDay.getRusName().equals("Среда")) {
                System.out.println("Сегодня " + eachDay.getRusName().toLowerCase() + ", до конца рабочей недели осталось " + eachDay.getWorkingHours() + " рабочих часа");
            } else if (eachDay.getRusName().equals("Суббота") || eachDay.getRusName().equals("Воскресенье")) {
                System.out.println("Сегодня " + eachDay.getRusName().toLowerCase() + ", до конца рабочей недели осталось " + eachDay.getWorkingHours() + " рабочих часов... можно покайфовать=)");
            } else
                System.out.println("Сегодня " + eachDay.getRusName().toLowerCase() + ", до конца рабочей недели осталось " + eachDay.getWorkingHours() + " рабочих часов");
        }

    }

}