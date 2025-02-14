class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int pg = bandage[0];
        int hs = bandage[1];
        int ph = bandage[2];

        int maxHealth = health;

        int lastAttack = attacks[attacks.length-1][0];
        int attackIdx = 0;
        int successiveHealth = 0;

        for (int i=1; i<=lastAttack; i++) {
            // 공격 처리
            if (attackIdx < attacks.length && attacks[attackIdx][0] == i) {
                health -= attacks[attackIdx][1];

                successiveHealth = 0;
                if (health <= 0) return -1;
                
                attackIdx += 1;
                continue;
            }

            // 회복 처리
            int tempHealth = 0;

            successiveHealth += 1;
            tempHealth += hs;

            if (successiveHealth == pg) {
                successiveHealth = 0;
                tempHealth += ph;
            }

            health = Math.min(maxHealth, health + tempHealth);
        }

        return health;
    }
}