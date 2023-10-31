package com.ll;

import java.util.ArrayList;
import java.util.Arrays;
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

            if(cmd.equals("종료")) break;

            else if(cmd.equals("등록")){
                System.out.println("명언) : ");
                String content = scanner.nextLine();
                System.out.println("작가) : ");
                String authorName = scanner.nextLine();
                int id = lastQuotationId++;
                Quotation quotation = new Quotation(id,content,authorName);
                quotations.add(quotation);
                System.out.println(quotation.getId()+"번 명언이 등록되었습니다.");
            }
            else if (cmd.equals("목록")){
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                for(int i=quotations.size()-1;i>=0;i--){
                    Quotation quotation = quotations.get(i);
                    System.out.println(quotation.getId()+1 + " / " + quotation.getAuthorName()+ " / " + quotation.getContent());
                }
            }
            else if (cmd.startsWith("삭제")){
                String[] cmdBits = cmd.split("\\?",2);
                System.out.println(Arrays.toString(cmdBits));
                if(cmdBits[1].isBlank()){
                    System.out.println("삭제할 id도 입력해주세요.");
                }
                int id = 0;
                String[] params = cmdBits[1].split("&");
                for(int i=0; i< params.length;i++){
                    String paramKey = params[i].split("=")[0];
                    String paramValue = params[i].split("=")[1];
                    if(paramKey.equals("id")) id = Integer.parseInt(paramValue);
                }
                for(int i=quotations.size()-1;i>=0;i--){
                    Quotation quotation = quotations.get(i);
                    if(quotation.getId() == id){
                        System.out.println(id+"번 명언이 삭제되었습니다.");
                    }
                }
            }
        }
    }
}
