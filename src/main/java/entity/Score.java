package entity;

public class Score {

	//ѧ��
	private Integer stuId;
	//���
	private Integer courseId;
	//�γ�
	private String courseName;
	//�ον�ʦ
	private String teacherName;
	//�ɼ�
	private Double scoreNum;
	
	
	public Integer getStuId() {
		return stuId;
	}
	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public Double getScoreNum() {
		return scoreNum;
	}
	public void setScoreNum(Double scoreNum) {
		this.scoreNum = scoreNum;
	}
	@Override
	public String toString() {
		return "Score [stuId=" + stuId + ", courseId=" + courseId + ", courseName=" + courseName + ", teacherName="
				+ teacherName + ", scoreNum=" + scoreNum + "]";
	}
	
	
	
}
