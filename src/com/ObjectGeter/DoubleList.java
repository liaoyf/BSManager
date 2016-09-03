package com.ObjectGeter;

import java.util.ArrayList;
import java.util.List;

public class DoubleList<E> {

	private List<E> List1 = new ArrayList<E>();
	private List<E> List2 = new ArrayList<E>();

	public DoubleList() {
		// TODO Auto-generated constructor stub
	}
	
	public DoubleList(List<E> list1, List<E> list2) {
		this.List1 = list1;
		this.List2 = list2;
		// TODO Auto-generated constructor stub
	}
	

	public List<E> getList1() {
		return List1;
	}

	public void setList1(List<E> list1) {
		List1 = list1;
	}

	public List<E> getList2() {
		return List2;
	}

	public void setList2(List<E> list2) {
		List2 = list2;
	}

}
