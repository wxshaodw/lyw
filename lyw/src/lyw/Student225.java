package lyw;

public class Student225 {
	private  String studentName;
	private  String studentId;
	private  String classId;



	String getStudentName(){
        return studentName;
}

	void setStudentName(String newName){
        studentName=newName;
}
	String getStudentId(){
        return studentId;
}

	void setStudentId(String newId){
        studentId=newId;
}
	String getclassId(){
        return classId;
}

	void setclassId(String newclassnId){
		classId=newclassnId;
}
	public static void main(String[] args) {
		Student225 s1=new Student225();
		s1.setStudentName("������");
		System.out.println("����Ϊ"+s1.studentName);
		s1.setStudentId("201435020225");
		System.out.println("ѧ��Ϊ"+s1.studentId);
		s1.setclassId("3502");
		System.out.println("�༶Ϊ"+s1.classId);
		System.out.println("����Ϊ"+s1.getStudentName());
		System.out.println("ѧ��Ϊ"+s1.getStudentId());
		System.out.println("�༶Ϊ"+s1.getclassId());
	}
	
}


