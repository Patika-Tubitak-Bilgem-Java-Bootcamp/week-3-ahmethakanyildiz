public class MyList<T>{
    private int count;
    private T[] list;
    private int initalCapacity;

    public MyList(){
        this.initalCapacity=10;
        this.count=0;
        this.list = (T[]) new Object[10];
    }

    public MyList(int capacity){
        this.initalCapacity=capacity;
        this.count=0;
        this.list = (T[]) new Object[capacity];
    }

    public int size(){
        return this.count;
    }

    public int getCapacity(){
        return this.list.length;
    }

    public void add(T element) {
        if (this.list.length == this.count) {
            T[] tempList = (T[]) new Object[2*this.list.length];
            for (int i=0; i< this.list.length; i++) {
                tempList[i] = this.list[i];
            }
            this.list = tempList;
        }
        this.list[this.count++] = element;
    }

    public T get(int index){
        if(index<0 || index>=count) return null;
        else return this.list[index];
    }

    public void remove(int index){
        if(!(index<0 || index>=this.count)){
            for(int i=index;i<this.count;i++){
                if(i==this.count-1) this.list[i]=null;
                else this.list[i]=this.list[i+1];
            }
            this.count--;
        }else{
            return;
        }
    }

    public void set(int index,T data){
        if(index<0 || index>=this.count) return;
        else{
            this.list[index]=data;
        }
    }

    public String toString(){
        String result = "[";
        for(int i=0;i<this.count;i++){
            result+=this.list[i];
            if(i!=this.count-1) result+=",";
        }
        result+="]";
        return result;
    }

    public int indexOf(T data){
        for(int i=0;i<this.count;i++){
            if(this.list[i].equals(data)){
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T data){
        for(int i=this.count-1;i>=0;i--){
            if(this.list[i].equals(data)){
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty(){
        if(this.count==0) return true;
        else return false;
    }

    public T[] toArray(){
        if(this.count==0) return (T[]) new Object[0];
        else{
            T[] array = (T[]) new Object[this.count];
            for(int i=0;i<this.count;i++){
                array[i]=this.list[i];
            }
            return array;
        }
    }

    public void clear(){
        this.list = (T[]) new Object[this.initalCapacity];
        this.count=0;
    }

    public MyList<T> subList(int start,int finish){
        if(start<0 || start>=this.count || finish<0 || finish>=this.count || start>finish) return null;
        else{
            int size = finish - start + 1;
            MyList<T> newList = new MyList<>(size);
            for(int i=start;i<=finish;i++){
                newList.add(this.list[i]);
            }
            return newList;
        }
    }

    public boolean contains(T data){
        for(int i=0;i<this.count;i++){
            if(this.list[i].equals(data)) return true;
        }
        return false;
    }






}
