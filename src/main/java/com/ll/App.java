package com.ll;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private Scanner scanner;
    private int lastQuotationId = 0;
    private ArrayList<Quotation> quotations;
    App(Scanner scanner) {
        this.scanner = scanner;

    }

    void run() {
        System.out.println("== 명언 앱 ==");
        quotations = new ArrayList<>();
        while (true){
            System.out.println("명령) :");
            String cmd = scanner.nextLine();
            Rq rq = new Rq(cmd);
            if(cmd.equals("종료")) break;

            else if(rq.getCmd().equals("등록")){
                System.out.println("명언) : ");
                String content = scanner.nextLine();
                System.out.println("작가) : ");
                String authorName = scanner.nextLine();
                int id = lastQuotationId++;
                Quotation quotation = new Quotation(id,content,authorName);
                quotations.add(quotation);
                System.out.println(quotation.getId() + 1 +"번 명언이 등록되었습니다.");
            }
            else if (rq.getCmd().equals("목록")){
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                for(int i=quotations.size()-1;i>=0;i--){
                    Quotation quotation = quotations.get(i);
                    System.out.println(quotation.getId()+1 + " / " + quotation.getAuthorName()+ " / " + quotation.getContent());
                }
            }
            else if (rq.getCmd().equals("삭제")){
                int id = rq.getParamAsInt("id",0);
                if(id == 0){
                    System.out.println("id가 없습니다.");
                }

                for(int i=quotations.size()-1;i>=0;i--){
                    Quotation quotation = quotations.get(i);
                    if(quotation.getId() == id){
                        quotations.remove(id);
                        System.out.println(id+"번 명언이 삭제되었습니다.");
                    }
                }
            }
        }
    }
}
