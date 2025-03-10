import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введіть команду (додати, видалити, показати, знайти, вихід):");
            String action = scanner.nextLine().toLowerCase();

            switch (action) {
                case "додати" -> {
                    System.out.println("Введіть назву книги: ");
                    String title = scanner.nextLine();

                    System.out.println("Введіть автора книги: ");
                    String author = scanner.nextLine();

                    System.out.println("Введіть рік випуску книги: ");
                    try {
                        int year = Integer.parseInt(scanner.nextLine());
                        library.addBook(new Book(title, author, year));
                    } catch (NumberFormatException e) {
                        System.out.println("Будь ласка, введіть коректний рік (число).");
                    }
                }
                case "видалити" -> {
                    System.out.println("Введіть назву книги: ");
                    String title = scanner.nextLine();
                    library.deleteBook(title);
                }
                case "знайти" -> {
                    System.out.println("Введіть за чим хочете знайти книгу (автор - 1, рік - 2):");
                    try {
                        int find = Integer.parseInt(scanner.nextLine());
                        switch (find) {
                            case 1 -> {
                                System.out.println("Введіть автора книги:");
                                String author = scanner.nextLine();
                                if (author.isEmpty()) {
                                    System.out.println("Автор не може бути порожнім.");
                                } else {
                                    boolean found = library.findBookForAuthor(author);
                                    if (!found) {
                                        System.out.println("Книги з автором \"" + author + "\" не знайдено.");
                                    }
                                }
                            }
                            case 2 -> {
                                System.out.println("Введіть рік випуску книги:");
                                try {
                                    int year = Integer.parseInt(scanner.nextLine());
                                    boolean found = library.findBookForYear(year);
                                    if (!found) {
                                        System.out.println("Книги з роком видання " + year + " не знайдено.");
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Будь ласка, введіть коректний рік (число).");
                                }
                            }
                            default -> System.out.println("Невірна команда. Виберіть 1 або 2.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Будь ласка, введіть число 1 або 2.");
                    }
                }
                case "показати" -> library.showBooks();
                case "вихід" -> {
                    System.out.println("Програма завершена.");
                    return;
                }
                default -> System.out.println("Невідома команда. Спробуйте ще раз.");
            }
        }
    }
}
