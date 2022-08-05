package src;
//Time Complexity: O(n)

import java.util.HashSet;
class Solution {
  public int numUniqueEmails(String[] emails) {
      HashSet<String> uniqueEmails = new HashSet<String>();
      for (int i = 0; i < emails.length; i++) {
          StringBuilder emailBuilder = new StringBuilder();
          String email = "invalid";
          boolean plus = false;
          for (int j = 0; j < emails[i].length(); j++) {
              char curr = emails[i].charAt(j);
              if (curr == '@') {
                  email = emailBuilder.toString() + emails[i].substring(j, emails[i].length());
                  break;
              } else if (plus || curr == '.') {
                  continue;
              } else if (curr == '+') {
                  plus = true;
                  continue;
              } else {
                  emailBuilder.append(curr);
              }
          }
          uniqueEmails.add(email);
      }
      return uniqueEmails.size();
  }
}