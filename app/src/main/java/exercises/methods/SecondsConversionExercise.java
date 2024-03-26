package exercises.methods;

import java.util.Scanner;
public class SecondsConversionExercise {
    Scanner scanner = new Scanner(System.in);
    int[] time = {0, 0, 0, 0};
    public void getSeconds() {
        int seconds;
        System.out.println("Informe os segundos para serem convertidos:");
        seconds = scanner.nextInt();
        time[0] = seconds;

        conversionMethod(time);
        System.out.println("Após a conversão dos Segundos, tivemos o resultado: \n  "+time[3]+" Dias, "+time[2]+" Horas, "+time[1]+" Minutos e "+time[0]+" Segundos");
    }

    public void conversionMethod(int[] time) {
        if (time[0] > 60) {
            time[1]=minutesConversion(time);
            if (time[1] > 60) {
                time[2] = hoursConversion(time);
                if (time[2] > 24) {
                    time[3] = daysConversion(time);
                }
            }
        }
    }

    public int minutesConversion(int[] time) {
        int minutes;
        minutes = time[0] / 60;
        time[0] = time[0] % 60;
        return minutes;
    }

    public int hoursConversion(int[] time) {
        int hours;
        hours = time[1] / 60;
        time[1] = time[1] % 60;
        return hours;
    }

    public int daysConversion(int[] time) {
        int days;
        days = time[2] / 24;
        time[2] = time[2] % 24;
        return days;
    }
}
