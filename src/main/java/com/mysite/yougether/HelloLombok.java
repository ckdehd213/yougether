package com.mysite.yougether;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class HelloLombok {

	private final String hello;
	private final int lombok;
	
	/*@RequiredArgsConstructor는 즉, 다음과 같이 생성자를 직접 작성한 경우와 동일하다. 
		public HelloLombok(String hello, int lombok) {
		this.hello = hello;
		this.lombok = lombok;
	}
	*/
	
	public static void main(String[] args) {
		
		HelloLombok helloLombok=new HelloLombok("헬로", 5);
		//helloLombok.setHello("헬로");
		//helloLombok.setLombok(5);
		
		System.out.println(helloLombok.getHello());
		System.out.println(helloLombok.getLombok());
	}
}
