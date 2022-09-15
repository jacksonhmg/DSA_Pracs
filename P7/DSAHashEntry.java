public class DSAHashEntry {
    public String key;
    public Object value;
    public int state;

    public DSAHashEntry()
    {
        key = "";
        value = null;
        state = 0;
    }

    public DSAHashEntry(String inKey, Object inValue)
    {
        key = inKey;
        value = inValue;
        state = 1;
    }
}
