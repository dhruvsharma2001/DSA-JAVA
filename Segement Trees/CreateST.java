public class CreateST {
    static int tree[];

    public static void initialise(int n){
        tree = new int[4*n];
    }

    public static int BuildST(int arr[], int i, int start, int end){ // i = ST ith index
        if(start == end){
            tree[i] = arr[start];
            return arr[start];
        }

        int mid = (start+end)/2;
        BuildST(arr, 2*i+1, start, mid); //left subtree = 2*i+1
        BuildST(arr, 2*i+2, mid+1, end); //right subtree = 2*i+2
        tree[i] = tree[2*i+1] + tree[2*i+2];
        // tree[i] = Math.max(tree[2*i+1], tree[2*i+2]); for maxST
        return tree[i];

    }
//-----------------------QUERY------------------------------------
    public static int getsumUtil(int i, int si, int sj, int qi, int qj){
        if(qj <= si || qi >= sj){ //non overlapping
            return 0;
        }else if(si>=qi && sj <= qj){ //complete overlapping
            return tree[i];
        }
        else{ //partial
            int mid = (si + sj)/2;
            int left = getsumUtil(2*i+1, si, mid, qi, qj);
            int right = getsumUtil(2*i+2, mid+1, sj, qi, qj);
            return left + right;

        }

    }

    public static int getsum(int arr[], int qi, int qj){
        int n = arr.length;
        return getsumUtil(0, 0, n-1, qi, qj);

    }

//------------------------UPDATE-------------------------------
public static void updateUtil(int i, int si, int sj, int idx, int diff){
    if(idx >= sj || idx <=si){
        return;
    }

    tree[i] += diff;
    if(si != sj){
        int mid = (si + sj)/2;
            updateUtil(2*i+1, si, mid, idx, diff);
            updateUtil(2*i+2, mid+1, sj, idx, diff);
          
    }
}
public static void update(int arr[], int idx, int newVal){
    int n = arr.length;
    int diff = newVal - arr[idx];
    arr[idx] = newVal;

    updateUtil(0, 0, n-1, idx, diff);
}
//------------------------MAIN FUNCTION-------------------------
    public static void main(String args[]){
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int n = arr.length;

        initialise(n);
        BuildST(arr, 0, 0, n-1);

        for(int i = 0; i<tree.length; i++){
            System.out.print(tree[i] + " ");
        }

        System.out.println(getsum(arr, 2, 5));
    }
}
