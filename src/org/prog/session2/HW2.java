package org.prog.session2;

public class HW2 {
    public static void main(String[] args) {
        String[] emails = new String[]{
                "abcd@gmail.com",
                "john.doe@gmail.com",
                "mymailgmail.com",
                "badmail@@gmail.com",
                "somemail@gmailcom",
                "somemail@gmail.com",
                "a@gmail.com",
                "abcdedfg@x.com",
                "abcdedfg@xzfgdasd.com"
        };

        for (int i = 0; i < emails.length; i++) {
            String email = emails[i];

            int firstAt = email.indexOf('@');
            int lastAt = email.lastIndexOf('@');

            if (firstAt == -1 || firstAt != lastAt) {
                continue;
            }

            if (firstAt < 3) {
                continue;
            }

            int dotAfterAt = email.indexOf('.', firstAt);
            if (dotAfterAt == -1) {
                continue;
            }

            if ((dotAfterAt - firstAt - 1) < 3) {
                continue;
            }

            System.out.println(email);
        }
    }
}