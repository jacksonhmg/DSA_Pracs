import java.util.NoSuchElementException;

public class BinarySearchTree
{
    private class TreeNode
    {
        private String m_key;
        private Object m_value;
        private TreeNode m_leftChild;
        private TreeNode m_rightChild;

        public TreeNode(String inKey, Object inVal)
        {
            if(inKey == null)
            {
                throw new IllegalArgumentException("Key cannot be null");
            }
            m_key = inKey;
            m_value = inVal;
            m_rightChild = null;
            m_leftChild = null;
        }

        public String getKey()
        {
            return m_key;
        }

        public Object getValue()
        {
            return m_value;
        }

        public TreeNode getLeft()
        {
            return m_leftChild;
        }

        public void setLeft(TreeNode newLeft)
        {
            m_leftChild = newLeft;
        }

        public TreeNode getRight()
        {
            return m_rightChild;
        }

        public void setRight(TreeNode newRight)
        {
            m_rightChild = newRight;
        }
    }


    private TreeNode m_root;

    public BinarySearchTree()
    {
        m_root = null;
    }

    public BinarySearchTree(String inKey, Object inValue)
    {
        m_root = new TreeNode(inKey, inValue);
    }

    public Object find(String key)
    {
        return findRec(key, m_root);
    }

    private Object findRec(String key, TreeNode currNode)
    {
        Object value = null;

        if(currNode == null)
        {
            throw new NoSuchElementException("Key " + key + " not found");
        }

        else if(key.equals(currNode.getKey()))
        {
            value = currNode.getValue();
        }

        else if(key.compareTo(currNode.getKey()) < 0)
        {
            value = findRec(key, currNode.getLeft());
        }

        else
        {
            value = findRec(key, currNode.getRight());
        }

        return value;
    }

    public void insert(String key, Object value)
    {
       insRec(key, value, m_root);
    }

    private TreeNode insRec(String key, Object data, TreeNode currNode)
    {
        TreeNode updateNode = currNode;
        if(currNode == null)
        {
            TreeNode newNode = new TreeNode(key, data);
            updateNode = newNode;
        }
        else if(key.equals(currNode.getKey()))
        {
            throw new IllegalArgumentException("That key already exists within this tree");
        }
        else if(key.compareTo(currNode.getKey()) < 0)
        {
            currNode.setLeft(insRec(key, data, currNode.getLeft()));
        }
        else
        {
            currNode.setRight(insRec(key, data, currNode.getRight()));
        }

        return updateNode;
    }

    public void delete(String key)
    {

    }

    public void display()
    {

    }

    public int min()
    {
        return minRec(m_root);
    }

    private int minRec(TreeNode currNode)
    {
        int minKey;
        if(currNode.getLeft() != null)
        {
            minKey = minRec(currNode.getLeft());
        }
        else
        {
            minKey = Integer.parseInt(currNode.getKey());
        }

        return minKey;
    }

    public int max()
    {
        return maxRec(m_root);
    }

    private int maxRec(TreeNode currNode)
    {
        int minKey;
        if(currNode.getRight() != null)
        {
            minKey = minRec(currNode.getRight());
        }
        else
        {
            minKey = Integer.parseInt(currNode.getKey());
        }

        return minKey;
    }

    public int height()
    {
        return heightRec(m_root);
    }

    private int heightRec(TreeNode currNode)
    {
        int htSoFar, iLeftHt, iRightHt;
        
        if(currNode == null)
        {
            htSoFar = -1;
        }
        else
        {
           iLeftHt = heightRec(currNode.getLeft());
           iRightHt = heightRec(currNode.getRight());
           
           // Get highest of left vs right branches
           if(iLeftHt > iRightHt)
           {
            htSoFar =  iLeftHt + 1;
           }
           else
           {
            htSoFar = iRightHt + 1;
           }
        }
        return htSoFar;
    }
    
    public double balance()
    {
        return balanceRec(m_root);
    }

    private double balanceRec(TreeNode currNode)
    {
        double iLeftHt, iRightHt, percentage;
        iLeftHt = 0;
        iRightHt = 0;
        percentage = 0;
        if(currNode != null)
        {
           iLeftHt = balanceRec(currNode.getLeft());
           iRightHt = balanceRec(currNode.getRight());
           
           // Get highest of left vs right branches
           if(iLeftHt > iRightHt)
           {
            percentage = iRightHt / iLeftHt;
           }
           else
           {
            percentage = iLeftHt / iRightHt;
           }
        }
        return percentage; 
    }

    public void traverseTreeRec(TreeNode currNode)
    {

    }

    public void inOrderTraverse()
    {
        inOrderRec(m_root);
    }

    private void inOrderRec(TreeNode currNode)
    {
        if(currNode.getLeft() != null)
        {
            inOrderRec(currNode.getLeft());
        }
        System.out.println(currNode.getKey());
        if(currNode.getRight() != null)
        {
            inOrderRec(currNode.getRight());
        }
    }
}