package observer;

import java.util.ArrayList;
import java.util.List;

public class TargetServer implements Observable{
	private String message;
	private List<Observer> list;
	
	public TargetServer() {
		list=new ArrayList<Observer>();
	}
	
	@Override
	public void registerObserver(Observer o) {
		list.add(o);
		
	}
	@Override
	public void removeObserver(Observer o) {
		// TODO Auto-generated method stub
		list.remove(o);
		System.out.println(o.getName()+" has been removed");
		System.out.println("---------------------");
	}
	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub
		for(int i=0;i<list.size();i++){
			Observer obs=list.get(i);
			obs.update(message);
		}
		System.out.println("---------------------");
	}
	public void setInformation(String s){
		this.message=s;
		System.out.println("Update info£º "+s);
		notifyObserver();
	}
}
