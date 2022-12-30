package observer;


import java.util.Stack;


public class UndoableStringBuilder {
    private StringBuilder stringBuilder;
    private Stack<String> stack;

    /**
     * this constructor initializes our UndoableStringBuilder type
     */

    public UndoableStringBuilder() {
        stringBuilder = new StringBuilder();
        stack = new Stack<>();
    }

    /**
     * Appends the specified string to this character sequence.
     * and pushing a deep copy of our object to our stack.
     *
     * @param str - the string we want to append
     * @return - UndoableStringBuilder address
     */

    public UndoableStringBuilder append(String str) {
        stringBuilder.append(str);
        stack.push(stringBuilder + "");
        return this;
    }

    /**
     * Removes the characters in a substring of this sequence. The substring begins
     * at the specified start and extends to the character at index
     * end - 1 or to the end of the sequence if no such character exists.
     * If start is equal to end, no changes are made.
     * and pushing a deep copy of our object to our stack.
     *
     * @param start - the first index we start to delete from
     * @param end   - the last index of the char sequence , not include
     * @return UndoableStringBuilder address
     * @throws StringIndexOutOfBoundsException - if insert negative index or
     *                                         start index bigger then string length or start > end
     */

    public UndoableStringBuilder delete(int start, int end) {
        if ((start < 0 || end < 0)) {
            throw new StringIndexOutOfBoundsException("please insert positive index");
        }
        if (start > this.stringBuilder.length()) {
            throw new StringIndexOutOfBoundsException("start argument must be under " + this.stringBuilder.length());
        }

        if (start > end) {
            throw new StringIndexOutOfBoundsException("end index must be greater or equal to start index");
        }

        stringBuilder.delete(start, end);

        stack.push(stringBuilder + "");
        return this;
    }

    /**
     * Inserts the string into this character sequence.
     * and pushing a deep copy of our object to our stack.
     *
     * @param offset - the start index of the char sequence where we want to offset
     * @param str    - input string
     * @return UndoableStringBuilder address
     * @throws StringIndexOutOfBoundsException - if insert negative offset or
     *                                         offset index bigger then string length
     */

    public UndoableStringBuilder insert(int offset, String str) {
        if (offset < 0) {
            throw new StringIndexOutOfBoundsException("please insert positive numbers");
        }
        if (offset > stringBuilder.length()) {
            throw new StringIndexOutOfBoundsException("offset index must be under " + (stringBuilder.length() + 1));
        }

        stringBuilder.insert(offset, str);
        stack.push(stringBuilder + "");
        return this;
    }

    /**
     * Replaces the characters in a substring of this sequence with characters in
     * the specified String. The substring begins at the specified start and
     * extends to the character at index end - 1 or to the end of the sequence if
     * no such character exists. First the characters in the substring are removed
     * and then the specified String is inserted at start. (This sequence will be
     * lengthened to accommodate the specified String if necessary).
     * and pushing a deep copy of our object to our stack.
     *
     * @param start - the start index of the char sequence
     * @param end   - the last index (not include)
     * @param str   - input string
     * @return UndoableStringBuilder address
     * @throws StringIndexOutOfBoundsException - if insert negative index or
     *                                         start index bigger then string length or start > end
     * @throws NullPointerException            if 'str' param is null
     */

    public UndoableStringBuilder replace(int start, int end, String str) {
        if ((start < 0 || end < 0)) {
            throw new StringIndexOutOfBoundsException("please insert positive index");
        }
        if (start > this.stringBuilder.length()) {
            throw new StringIndexOutOfBoundsException("start argument must be under " + this.stringBuilder.length());
        }

        if (start > end) {
            throw new StringIndexOutOfBoundsException("end index must be greater or equal to start index");
        }

        if (str == null) {
            throw new NullPointerException();
        }

        stringBuilder.replace(start, end, str);
        stack.push(stringBuilder + "");
        return this;
    }

    /**
     * Causes this character sequence to be replaced by the reverse of the
     * sequence.
     *
     * @return - UndoableStringBuilder address
     */

    public UndoableStringBuilder reverse() {
        stringBuilder.reverse();
        stack.push(stringBuilder + "");
        return this;
    }

    /**
     * @return - string of our stringbuilder object
     */

    @Override
    public String toString() {
        return this.stringBuilder + "";
    }

    /**
     * return our stringbuilder to the last object before the last change
     * (do nothing if we undo the latest string)
     */

    public void undo() {
        if (stack.isEmpty()) {
            stringBuilder = new StringBuilder();
        } else if (stack.size() == 1) {
            stack.pop();
            stringBuilder = new StringBuilder();
        } else {
            String s;
            stack.pop();
            s = stack.peek();
            stringBuilder = new StringBuilder(s);
        }


    }
}
