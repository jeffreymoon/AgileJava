package sis.studentinfo;

public class Course {

	private String department;
	private String number;

	public Course(String department, String number) {
		this.department = department;
		this.number = number;
	}

	public String getDepartment() {
		return department;
	}

	public String getNumber() {
		return number;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		return result;
	}

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Course other = (Course) obj;
//		if (department == null) {
//			if (other.department != null)
//				return false;
//		} else if (!department.equals(other.department))
//			return false;
//		if (number == null) {
//			if (other.number != null)
//				return false;
//		} else if (!number.equals(other.number))
//			return false;
//		return true;
//	}

	@Override
	public boolean equals(Object object) {
		if (object == null) {
			return false;
		}
		if (this.getClass() != object.getClass()) {
			return false;
		}
		Course that = (Course) object;
		return this.department.equals(that.department)
				&& this.number.equals(that.number);
	}

}
