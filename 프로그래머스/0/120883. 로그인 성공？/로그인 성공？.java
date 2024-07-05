class Solution {
    public String solution(String[] id_pw, String[][] db) {
        String id = id_pw[0];
        String password = id_pw[1];
        
        for (String[] user : db) {
            if (user[0].equals(id) && user[1].equals(password)) {
                return "login";
            } else if (user[0].equals(id)) {
                return "wrong pw";
            }
        }
        return "fail";
    }
}