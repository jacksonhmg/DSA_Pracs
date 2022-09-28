public class DSAHashTable {
    public DSAHashEntry[] hashArray;

    public DSAHashTable(int tablesize)
    {
        int actualSize = findNextPrime(tablesize);
        hashArray = new DSAHashEntry[actualSize];
        for(int i = 0; i<actualSize;i++)
        {
            hashArray[i] = new DSAHashEntry();
        }
    }

    public int findNextPrime(int startVal)
    {
        int primeVal;
        double rootVal;
        if(startVal % 2 == 0)
        {
            primeVal = startVal - 1;
        }
        else
        {
            primeVal = startVal;
        }
        boolean isPrime = false;
        do
        {
            primeVal +=2;
            int ii = 3;
            isPrime = true;
            rootVal = Math.sqrt(primeVal);
            do
            {
                if(primeVal % ii == 0)
                {
                    isPrime = false;
                }
                else
                {
                    ii += 2;
                }

            }while(ii <= rootVal && (isPrime));
        }while(!isPrime);
        return primeVal;
    }

    public int hash(String key)
    {
        long hashIdx = 0;

        for(int i = 0; i<key.length(); i++)
        {
            hashIdx = (31* hashIdx) + key.charAt(i);
            //System.out.print(" Hash: " + hashIdx);
        }
        int toReturn = (int)(hashIdx % hashArray.length);
        //System.out.print(" HashIdx%hAL: " + hashIdx % hashArray.length);
        return toReturn;
    }

    public int stepHash(String inKey)
    {
        int key = 0;
        for(int i = 0; i < inKey.length(); i++)
        {
            key += (int)inKey.charAt(i);
        }
        int max_step = 13;
        int hashStep = max_step - (key % max_step);
        return hashStep;
    }

    public Object get(String inKey)
    {
        int hashIdx = hash(inKey);
        int origIdx = hashIdx;
        boolean found = false;
        boolean giveUp = false;

        while(!found && !giveUp)
        {
            if(hashArray[hashIdx].state == 0)
            {
                giveUp = true;
                //System.out.println("\nState equals zero");
            }
            else if(hashArray[hashIdx].key.equals(inKey))
            {
                found = true;
            }
            else
            {
                hashIdx = (hashIdx + stepHash(inKey));
                if(hashIdx >= hashArray.length)
                {
                    hashIdx = hashIdx - hashArray.length;
                }
                if(hashIdx == origIdx)
                {
                    giveUp = true;
                    //System.out.println("\n== orig");
                }
            }
        }
        if(!found)
        {
            throw new IllegalArgumentException("Can't find");
        }
        return hashArray[hashIdx].value;
    }

    public boolean hasKey(String inKey)
    {
        int hashIdx = hash(inKey);
        int origIdx = hashIdx;
        boolean found = false;
        boolean giveUp = false;

        while(!found && !giveUp)
        {
            if(hashArray[hashIdx].state == 0)
            {
                giveUp = true;
            }
            else if(hashArray[hashIdx].key.equals(inKey))
            {
                found = true;
            }
            else
            {
                hashIdx = (hashIdx + stepHash(inKey));
                if(hashIdx >= hashArray.length)
                {
                    hashIdx = hashIdx - hashArray.length;
                }
                if(hashIdx == origIdx)
                {
                    giveUp = true;
                }
            }
        }
    
        return found;
    }

    public void put(String inKey, Object inValue)
    {
        //System.out.println(" putting : ");
        int hashIdx = hash(inKey);
        int origIdx = hashIdx;
        while((hashArray[hashIdx].state != 0) && (hashArray[hashIdx].state != 2))
        {
            hashIdx = (hashIdx + stepHash(inKey));
            if(hashIdx >= hashArray.length)
            {
                hashIdx = hashIdx - hashArray.length;
            }
            //System.out.println(hashIdx);
            if(hashIdx == origIdx)
            {
                throw new IllegalArgumentException("Cannot insert, hashIdx == origIdx");
            }
        }
        hashArray[hashIdx] = new DSAHashEntry(inKey, inValue);
    }

    public void remove(String inKey, Object inValue)
    {
        int hashIdx = hash(inKey);
        int origIdx = hashIdx;
        boolean found = false;
        boolean giveUp = false;

        while(!found && !giveUp)
        {
            if(hashArray[hashIdx].state == 0)
            {
                giveUp = true;
            }
            else if(hashArray[hashIdx].key.equals(inKey))
            {
                found = true;
            }
            else
            {
                hashIdx = (hashIdx + stepHash(inKey));
                if(hashIdx >= hashArray.length)
                {
                    hashIdx = hashIdx - hashArray.length;
                }
                if(hashIdx == origIdx)
                {
                    giveUp = true;
                }
            }
        }
        if(!found)
        {
            throw new IllegalArgumentException("Can't find to delete");
        }
        if(found)
        {
            hashArray[hashIdx].key = "";
            hashArray[hashIdx].value = null;
            hashArray[hashIdx].state = 2;
        }
    }


    public void resizeCheck()
    {
        if(shouldResize() == 1)
        {
            growResize();
        }
        else if(shouldResize() == 2)
        {
            shrinkResize();
        }
    }


    public int shouldResize()
    {
        int counter = 0;
        for(int i = 0; i < hashArray.length; i++)
        {
           if(hashArray[i].state == 1)
           {
            counter++;
           } 
        }
        if(counter >= (hashArray.length/2))
        {
            return 1;
        }
        if(counter <= (hashArray.length)/10)
        {
            return 2;
        }
        return 0;
    }

    public void growResize()
    {
        DSAHashEntry[] tempArr = hashArray;
        int actualSize = findNextPrime((hashArray.length)*2);
        hashArray = new DSAHashEntry[actualSize];
        //System.out.print(" GROWN TO " + hashArray.length + "!!!");
        for(int i = 0; i<actualSize;i++)
        {
            hashArray[i] = new DSAHashEntry();
        }
        for(int i = 0; i<tempArr.length;i++)
        {
            if(tempArr[i].state == 1)
            {
                put(tempArr[i].key, tempArr[i].value);
            }
        }
    }

    public void shrinkResize()
    {
        DSAHashEntry[] tempArr = hashArray;
        int actualSize = findNextPrime((hashArray.length)/2);
        hashArray = new DSAHashEntry[actualSize];
        //System.out.print(" SHRUNK TO " + hashArray.length + "!!!");
        for(int i = 0; i<actualSize;i++)
        {
            hashArray[i] = new DSAHashEntry();
        }
        for(int i = 0; i<tempArr.length;i++)
        {
            if(tempArr[i].state == 1)
            {
                put(tempArr[i].key, tempArr[i].value);
            }
        }
    }
    
}
