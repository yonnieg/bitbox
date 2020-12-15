package member;

import java.io.Serializable;

public class Member implements Serializable{	//이전 파일에서 Serializable되어있었는지 확인해보자
   private String id;
   private String password;
   private String card;
   private String selectmovie=null;
   private String selectShowTime=null;
   private String selectSeat=null;
   
   Member(){}
   public Member(String id, String password, String card){
      this.id = id;
      this.password = password;
      this.card = card;
   }
   public String toString() {	//수정-이동희 
	   return 		  "[이름] : "+ id +
			  "[비밀번호] : "+ password +
			  "[카드번호] : "+""+ card +
			  "[예매 영화] : "+""+ selectmovie +
			  "[예매 시간] : "+""+ selectShowTime +
			  "[예매 좌석] : "+""+ selectSeat;
   }
   //이름 가져오기
   public void setId(String id) {
      this.id = id;
   }
   //비번 가져오기
   public void setPassword(String password) {
      this.password = password;
   }
   //카드번호 가져오기
   public void setCard(String card) {
      this.card = card;
   }
   public void setAll(String id, String pass, String card) {
      this.id = id;
      this.password = pass;
      this.card = card;
      
   }
   public String getSelectSeat() {
	   return selectSeat;
   }
   //이름 가져오기
   public String getId() {
      return id;
   }
   //비번 가져오기
   public String getPassword() {
      return password;
   }
   //카드번호 가져오기
   public String getCard() {
      return card;
   }
   public void setSelectMovie(String selectmovie) {
      this.selectmovie = selectmovie;
   }
   public void setSelectShowTime(String selectShowTime) {
      this.selectShowTime = selectShowTime;
   }
   public void setselectSeat(String selectSeat) {
      this.selectSeat = selectSeat;
   }
   public void setselAll(String selectmovie,String selectShowTime,String selectSeat) {
	   this.selectmovie = selectmovie;
	   this.selectShowTime = selectShowTime;
	   this.selectSeat = selectSeat;
   }
   public String getSelectShowTime() {
	   return selectShowTime;
   }
   public void getSelectMovie() {
//		System.out.println( "┌──────────────────────────────────────────────────┐"); 
//		System.out.println( "│                  	비 트 영 화 관                			│"); 
//		System.out.println( "│                                      		    │");
//		System.out.println( "│                                       		    │");
//		System.out.println( "│   영화제목 :" + selectmovie                	      +"│");
//		System.out.println( "│   시      간 :" + selectShowTime                	  +"│");
//		System.out.println( "│   좌      석 :" + selectSeat                     	  +"│");
//		System.out.println( "│   고  객 명 :" + getId()                     	  +"│");
//		System.out.println( "│                                     			    │");
//		System.out.println( "│                                       		    │");
//		System.out.println( "│					                            ∥ ∥ ∥ ∥ ∥ ∥ ∥ ∥ ∥  ∥ ∥ ∥    │ 		    │");
//		System.out.println( "└──────────────────────────────────────────────────┘");
		System.out.println("");
		System.out.println("------------------------------------");
		System.out.printf("[영화  제목] : %s\n[상영  시간] : %s\n[좌    석] : %s\n[회원 아이디] : %s\n", selectmovie,selectShowTime,selectSeat,getId());
		System.out.println("------------------------------------");
		System.out.println();
					
	}
}