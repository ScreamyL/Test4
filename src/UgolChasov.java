
import java.util.Scanner;

public class UgolChasov {
    public static double calculateClockAngle(int hours, int minutes) {
        if (hours < 0 || hours > 12 || minutes < 0 || minutes > 59) {
            throw new IllegalArgumentException("Некорректное время");
        }

        // Рассчитываем угол для минутной стрелки
        double minuteAngle = 6 * minutes; // 360 градусов / 60 минут = 6 градусов в минуте

        // Рассчитываем угол для часовой стрелки, учитывая плавный ход часовой стрелки
        double hourAngle = 30 * hours + 0.5 * minutes; // 360 градусов / 12 часов = 30 градусов в часе

        // Находим разницу между углами
        double angle = Math.abs(hourAngle - minuteAngle);

        // Находим угловую разницу поменьше, если это убрать, получается бОльший угол
        if (angle > 180) {
            angle = 360 - angle;
        }

        return angle;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите часы(12-ти часовой формат): ");
        int hours = scanner.nextInt();

        System.out.print("Введите минуты: ");
        int minutes = scanner.nextInt();

        double angle = calculateClockAngle(hours, minutes);
        System.out.println("Угол между часовой и минутной стрелками: " + angle + " градусов");

        scanner.close();
    }
}
