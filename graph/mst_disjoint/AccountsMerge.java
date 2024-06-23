package graph.mst_disjoint;

import java.util.ArrayList;
import java.util.HashMap;
/*
 * Accounts Merge
 * 
 * Given a list of accounts where each element account [ i ] is a list of strings, where the first element account [ i ][ 0 ]  is a name, and the rest of the elements are emails representing emails of the account.
Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some common email to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.
After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in sorted order.

Example 1:
Input: N = 4
accounts [ ] =
[["John","johnsmith@mail.com","john_newyork@mail.com"],
["John","johnsmith@mail.com","john00@mail.com"],
["Mary","mary@mail.com"],
["John","johnnybravo@mail.com"]]

Output: [["John","john00@mail.com","john_newyork@mail.com", "johnsmith@mail.com"],
["Mary","mary@mail.com"],
["John","johnnybravo@mail.com"]]

Explanation: The first and the second John are the same person as they have a common email. But the third Mary and fourth John are not the same as they do not have any common email.  The result can be in any order but the emails must be in sorted order. The following is also a valid result:
[['Mary', 'mary@mail.com'],
['John', 'johnnybravo@mail.com'],
['John', 'john00@mail.com' , 'john_newyork@mail.com', 'johnsmith@mail.com' ]]

Example 2:
Input: N = 6
accounts [ ] =
[["John","j1@com","j2@com","j3@com"],
["John","j4@com"],
["Raj",”r1@com”, “r2@com”],
["John","j1@com","j5@com"],
["Raj",”r2@com”, “r3@com”],
["Mary","m1@com"]]

Output: [["John","j1@com","j2@com","j3@com","j5@com"],
["John","j4@com"],
["Raj",”r1@com”, “r2@com”,  “r3@com”],
["Mary","m1@com"]]

Explanation: The first and the fourth John are the same person here as they have a common email. And the third and the fifth Raj are also the same person. So, the same accounts are merged.
 */

public class AccountsMerge {
    public static String merge(int n, String[][] accounts) {
        DisjointSet_Size ds = new DisjointSet_Size(n);

        HashMap<String,Integer> emailMap = new HashMap<>();
        for(int i = 0; i < accounts.length; i++) {
            for(int j = 1; j < accounts[i].length; j++) {
                if(!emailMap.containsKey(accounts[i][j])) {
                    emailMap.put(accounts[i][j], i);
                }else {
                    int node = emailMap.get(accounts[i][j]);
                    ds.unionBySize(i, node);
                }
            }
        }

        ArrayList<String>[] emails = new ArrayList[n];
        emailMap.forEach((String email, Integer node) -> {
            int parent = ds.getUParent(node);
            if(emails[parent] == null) {
                emails[parent] = new ArrayList<String>();
                emails[parent].add(accounts[parent][0]);
            }
            emails[parent].add(email);
        });

        StringBuilder sb = new StringBuilder();
        for(ArrayList<String> acc : emails) {
            if(acc != null) {
                sb.append(acc.toString());
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
