package com.education.ztu;

public class StringBuilderExample {
    public static void main(String[] args) {
        int a = 4;
        int b = 36;

        // Використовуємо StringBuilder для формування рядків
        StringBuilder sb = new StringBuilder();

        // Додавання математичних виразів з операціями
        sb.append(a).append(" + ").append(b).append(" = ").append(a + b).append("\n")
                .append(a).append(" - ").append(b).append(" = ").append(a - b).append("\n")
                .append(a).append(" * ").append(b).append(" = ").append(a * b).append("\n");

        // Вивід результатів
        System.out.println("Результати математичних операцій:");
        System.out.println(sb.toString());

        // Заміна символу "=" на "рівно" за допомогою insert() та deleteCharAt()
        int indexOfEquals;
        while ((indexOfEquals = sb.indexOf("=")) != -1) {
            sb.deleteCharAt(indexOfEquals);
            sb.insert(indexOfEquals, "рівно");
        }
        System.out.println("Заміна '=' на 'рівно' (використовуючи insert та deleteCharAt):");
        System.out.println(sb.toString());

        // Відновлення початкового вигляду для наступної заміни
        sb = new StringBuilder();
        sb.append(a).append(" + ").append(b).append(" = ").append(a + b).append("\n")
                .append(a).append(" - ").append(b).append(" = ").append(a - b).append("\n")
                .append(a).append(" * ").append(b).append(" = ").append(a * b).append("\n");

        // Заміна "=" на "рівно" за допомогою replace()
        while ((indexOfEquals = sb.indexOf("=")) != -1) {
            sb.replace(indexOfEquals, indexOfEquals + 1, "рівно");
        }
        System.out.println("Заміна '=' на 'рівно' (використовуючи replace):");
        System.out.println(sb.toString());

        // Перевертання рядка
        sb.reverse();
        System.out.println("Перевернутий рядок:");
        System.out.println(sb.toString());

        // Визначення довжини та ємності
        System.out.println("Довжина рядка: " + sb.length());
        System.out.println("Capacity: " + sb.capacity());
    }
}
