function changePage(currentPage,pageRecord){
	$("#currentPage").val(currentPage);
	$("#pageRecord").val(pageRecord);
	$("#customerForm").submit(); 
}