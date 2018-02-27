package xyz.mynt.internal.builder;

public class CriteriaBuilder {

	//String requestJSON = "{ \"jql\" : \"project = HRANOMMNL AND assignee in ('pcruz', 'llorente')\" }";
	
	
	public static String buildRequest(String[] assignees, String[] projects) {
		StringBuilder request = new StringBuilder("{ \"jql\" : \"\"}");
		if(projects.length > 0) {
			request.insert(request.length()-3, " project in ( ");
			for(int i = 0; i < projects.length; i++) {
				request.insert(request.length()-3, projects[i]);
				if(i<projects.length-1)
					request.append(", ");
			}
			request.append(" )");
			System.out.println("PROJECT " + request.toString() );
		}
		if(assignees.length > 0) {
		}	
		return request.toString();
	}

}
