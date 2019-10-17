import java.util.*;
public class library
{
	int Code[]=new int[5];
	String Name[]=new String[5];
	String Author[]=new String[5];
	int present_copies_left[]=new int[5];

	int a=0;
	int roll_no[]=new int[100];
	String student_name[]=new String[100];
	
	public void set_student_data()								//SET_STUDENT_DATA//
 	{
 		for(int i=0;i<100;i++)
 		{
			roll_no[i]=0;
			student_name[i]="NULL";
		}
	}
	public void add_new_book(String name,String author,int code,int copies)			//ADD_NEW_BOOK//
 	{
		if(a<5)
	 	{
			Name[a]=name;
			Author[a]=author;
			Code[a]=code;
			present_copies_left[a]=copies;
			a++;
		}
		else
		{
			System.out.println("LIMIT ACHIEVED");
 		}
	}
	public void issue_book(int CODE, int ROLL_NO, String NAME)				//ISSUE_BOOK//
	{
		int n=index(CODE);
		if(n==-1)
		{
			System.out.println("\t\t --------------");
			System.out.println("\t\t |NO SUCH CODE|");
			System.out.println("\t\t --------------");
		}
		if(present_copies_left[n]==0)
		{
			System.out.println("\t\t --------------");
			System.out.println("\t\t |NO Copies Left|");
			System.out.println("\t\t --------------");
		}
		else
		{
			--present_copies_left[n];
			System.out.println("\t\t ------------------------------------------");
			System.out.println("\t\t |New Book Issued By "+NAME+"("+ROLL_NO+")|");
			show_details(n);
 			System.out.println("\t\t |COPIES LEFT : "+present_copies_left[n]);
			System.out.println("\t\t ------------------------------------------");
 		}
 	}
	public void student_issued_book_data()							//STUDENT_ISSUED_BOOK_DATA//
	{
		for(int i=0;i<a;i++)
		{
			System.out.println("\t\t ---------------------------------------------------------------------");
			System.out.println("\t\t |"+Code[i]+"\tStudent's Name:"+student_name[i]+"\tRoll No.:"+roll_no[i]+"|");
			System.out.println("\t\t ---------------------------------------------------------------------");
		}
	}							
	public void return_book(int CODE)							//RETURN_BOOK//
 	{
		int n=index(CODE);
		if(n==-1)
		{
			System.out.println("\t\t --------------");
			System.out.println("\t\t |NO SUCH CODE|");
			System.out.println("\t\t --------------");
		}
		else
		{
			System.out.println("\t\t -----------------------------------------");
			System.out.println("\t\t |Details of books returned:-");
			show_details(n);
			++present_copies_left[n];
			System.out.println("\t\t |COPIES LEFT : "+present_copies_left[n]);
			System.out.println("\t\t |Book returned");
			System.out.println("\t\t ------------------------------------------");
		}
	}
	public void show_details(int ind)							//SHOW_DETAILS//
	{
		System.out.println("\t\t |BOOK's NAME : "+Name[ind]+"|");
		System.out.println("\t\t |AUTHOR's NAME : "+Author[ind]+"|");
	}	
	public int index(int CODE)								//INDEX//
 	{
		for(int i=0;i<=a;i++)
		{
			if(Code[i]==CODE)
			{
				return i;
			}
		}
		return -1;
	}
	public void books_in_library_left()							//BOOKS_IN_LIBRARY_LEFT//
 	{
		for(int i=0;i<a;i++)
		{
			System.out.println("\t\t ----------------------------");
			System.out.println("\t\t |"+Code[i] + "\t" + Name[i]+"|");
			System.out.println("\t\t ----------------------------");
		}
	}
	public void add_student_data(String Student_name,int Roll_no)				//ADD_STUDENT_DATA//
	{
		for(int i=0;i<100;i++)
		{
			if(roll_no[i]==0)
			{
				roll_no[i]=Roll_no;
				student_name[i]=Student_name;
				break;
			}
		}
	}
	public void remaining_student_data(int Roll_no)						//REMAINING_STUDENT_DATA//
 	{
		for(int i=0;i<100;i++)
		{
			if(roll_no[i]==Roll_no)
 			{
				roll_no[i]=0;
				student_name[i]="Null";
				break;
			}
			else
			{
				System.out.println("\t\t ----------------------");
				System.out.println("\t\t |Roll Number Not Found");
				System.out.println("\t\t ----------------------");
				break;
			}
 		}
 	}
	public void display_due()								//DISPLAY_DUE//
	{
		for(int i=0;i<100;i++)
		{
			if(roll_no[i] != 0)
			{
				System.out.println("\t\t ------------------------------------------------------------------------");
				System.out.println("\t\t |ROLL_NO :"+roll_no[i]+"   STUDENT_NAME :"+student_name[i]+"   BOOK'S_NAME :"+Name[i]+"|");
				System.out.println("\t\t ------------------------------------------------------------------------");
			}
			//else if(roll_no[i] == 0)
			//{
			//	System.out.println("\t\t ---------------------");
			//	System.out.println("\t\t |NO DUE'S TO DISPLAY|");
			//	System.out.println("\t\t ---------------------");
			//	break;
			//}

		}
 	}
public static void main(String args[])
{
	library ob = new library();

	ob.set_student_data();
	int choose;
	int roll_no,code,copies;
	int count = 101;
	String name;
	String author;
	Scanner sc = new Scanner(System.in);
	
 	System.out.println("\t \t\t\t\t\t\t\t   WELCOME....!!!\n\t\t\t\t\t\t\tThis is Library Managment System");
	for(;;)
	{
 		System.out.println("1. Add a book in Library \n2. Issue a Book \n3. Return a Book \n4. display due list \n5. Exit");
		System.out.print("->");
	 	choose=sc.nextInt();
 		while(choose==1||choose==2||choose==3||choose==4||choose==5)
 		{
 			if(choose == 1)								//ADD//
 			{
	 			System.out.println("Enter code of Book to be added :");
				code = sc.nextInt();
				//code = count;
				//count++;
				System.out.println("Enter number of Copies :");
				copies = sc.nextInt();
				System.out.println("Enter Name of Book:");
				sc.nextLine();
				name = sc.nextLine();
				System.out.println("Enter Name of Author :");
				author = sc.nextLine();
				ob.add_new_book(name,author,code,copies);

				System.out.println("\t\t |-----------------------|");
				System.out.println("\t\t |--> New book added <-- |");
				System.out.println("\t\t |-----------------------|");
				break;
 			}
			if(choose == 2)							//ISSUE//
	 		{
				System.out.println("Please Enter Code of Book to be issued :");
				ob.books_in_library_left();
				System.out.print("-> ");
				code = sc.nextInt();
				System.out.println("Please Enter your Roll Number :");
				roll_no = sc.nextInt();
				System.out.println("Please Enter Your Name :");
				sc.nextLine();
				name = sc.nextLine();
				ob.issue_book(code,roll_no,name);
				ob.add_student_data(name,roll_no);			
				break;
	 		}	
			if(choose == 3)							//RETURN//
			{
				System.out.println("Please Enter your CODE of Book to be returned ");
				ob.student_issued_book_data();
				code = sc.nextInt();
				System.out.println("Enter your ROLL NUMBER");
				sc.nextLine();
				roll_no = sc.nextInt();
				ob.return_book(code);
				ob.remaining_student_data(roll_no);
				break;
	 		}
	 		if(choose == 4)									//DISPLAY//
	 		{
				ob.display_due();
				break;
			}
			if(choose == 5)									//EXIT//
	 		{
				System.exit(0);
			}
 
 		}
	}
}
}
