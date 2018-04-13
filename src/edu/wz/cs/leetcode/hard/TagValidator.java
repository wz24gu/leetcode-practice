package edu.wz.cs.leetcode.hard;

import java.util.Stack;

/**
 * 591. Tag Validator<br>
 * https://leetcode.com/problems/tag-validator<br><br>
 * 
 * Given a string representing a code snippet, you need to implement a tag validator to parse the code and return whether 
 * it is valid. A code snippet is valid if all the following rules hold:<br>
 * 1. The code must be wrapped in a valid closed tag. Otherwise, the code is invalid.<br>
 * 2. A closed tag (not necessarily valid) has exactly the following format : <TAG_NAME>TAG_CONTENT</TAG_NAME>. Among 
 * them, <TAG_NAME> is the start tag, and </TAG_NAME> is the end tag. The TAG_NAME in start and end tags should be the 
 * same. A closed tag is valid if and only if the TAG_NAME and TAG_CONTENT are valid.<br>
 * 3. A valid TAG_NAME only contain upper-case letters, and has length in range [1,9]. Otherwise, the TAG_NAME is invalid.<br>
 * 4. A valid TAG_CONTENT may contain other valid closed tags, cdata and any characters (see note1) EXCEPT unmatched <, 
 * unmatched start and end tag, and unmatched or closed tags with invalid TAG_NAME. Otherwise, the TAG_CONTENT is invalid.<br>
 * 5. A start tag is unmatched if no end tag exists with the same TAG_NAME, and vice versa. However, you also need to 
 * consider the issue of unbalanced when tags are nested.<br>
 * 6. A < is unmatched if you cannot find a subsequent >. And when you find a < or </, all the subsequent characters 
 * until the next > should be parsed as TAG_NAME (not necessarily valid).<br>
 * 7. The cdata has the following format : <![CDATA[CDATA_CONTENT]]>. The range of CDATA_CONTENT is defined as the 
 * characters between <![CDATA[ and the first subsequent ]]>.<br>
 * 8. CDATA_CONTENT may contain any characters. The function of cdata is to forbid the validator to parse CDATA_CONTENT, 
 * so even it has some characters that can be parsed as tag (no matter valid or invalid), you should treat it as regular 
 * characters.<br>
 * 
 * Note: For simplicity, you could assume the input code (including the any characters mentioned above) only contain 
 * letters, digits, '<','>','/','!','[',']' and ' '.
 */
public class TagValidator {
    
    public static boolean solution(String code) {
        Stack<String> stack = new Stack<>();
        
        int n = code.length();
        for (int i = 0; i < n; ) {
            if (i > 0 && stack.isEmpty()) {
                return false;  // no beginning tag
            }
            
            if (code.startsWith("<![CDATA[", i)) {
                int j = i + 9;
                i = code.indexOf("]]>", j);
                if (i < 0) {
                    return false;  // no ending tag for cdata
                }
                i += 3;
            }
            else if (code.startsWith("</", i)) {
                int j = i + 2;
                i = code.indexOf(">", j);
                if (i < 0 || i == j || i - j > 9) {
                    return false;  // ending tag not found, no tag name, or tag name > 9
                }
                for (int k = j; k < i; k++) {
                    if (code.charAt(k) < 'A' || code.charAt(k) > 'Z') {
                        return false;  // tag name not uppercase
                    }
                }
                String tagName = code.substring(j, i++);
                if (stack.isEmpty() || !stack.pop().equals(tagName)) {
                    return false;  // tag name does not match
                }
            }
            else if (code.startsWith("<", i)) {
                int j = i + 1;
                i = code.indexOf(">", j);
                if (i < 0 || i == j || i - j > 9) {
                    return false;
                }
                for (int k = j; k < i; k++) {
                    if (code.charAt(k) < 'A' || code.charAt(k) > 'Z') {
                        return false;
                    }
                }
                String tagName = code.substring(j, i++);
                stack.push(tagName);
            }
            else {
                i++;
            }
        }
        
        return stack.isEmpty();
    }
    
    public static void main(String[] args) {
        System.out.println(TagValidator.solution("<DIV>This is the first line <![CDATA[<div>]]></DIV>"));
        System.out.println(TagValidator.solution("<DIV>>>  ![cdata[]] <![CDATA[<div>]>]]>]]>>]</DIV>"));
        
        System.out.println(TagValidator.solution("<A>  <B> </A>   </B>"));
        System.out.println(TagValidator.solution("<DIV>  div tag is not closed  <DIV>"));
        System.out.println(TagValidator.solution("<DIV>  unmatched <  </DIV>"));
        System.out.println(TagValidator.solution("<DIV> closed tags with invalid tag name  <b>123</b> </DIV>"));
        System.out.println(TagValidator.solution("<DIV> unmatched tags with invalid tag name  </1234567890> and <CDATA[[]]>  </DIV>"));
        System.out.println(TagValidator.solution("<DIV>  unmatched start tag <B>  and unmatched end tag </C>  </DIV>"));
    }

}
