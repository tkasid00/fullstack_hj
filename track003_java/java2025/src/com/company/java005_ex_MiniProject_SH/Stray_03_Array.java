package com.company.java005_ex_MiniProject_SH;

import java.util.Arrays;
import java.util.Scanner;

public class Stray_03_Array {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int num = -1, i = 0;
		String tempid = null, temppass = null;
		char yn = '\u0000';
		boolean login = false;

		String[] id = new String[3];
		String[] pass = new String[3];

		String[] kind = new String[3];
		String[] catname = new String[3];
		String[] point = new String[3];

		String[] bowl = new String[3];
		String[] toy = new String[3];
		String[] bath = new String[3];
		String[] tower = new String[3];
		String[] hide = new String[3];

		int[] age = new int[3];
		int[] healthy = new int[3];
		int[] happy = new int[3];
		int[] clean = new int[3];
		int[] lv = new int[3];
		int[] reliance = new int[3];
		int[] bonus = new int[3];

		// 역순으로 계산하면 레벨 미반영 문제 해결됨...이걸 생각 못해서 머리터질뻔
		if (lv[i] < 5) {
			if (happy[i] >= 50 && reliance[i] >= 50 && healthy[i] >= 50 && clean[i] >= 50) {
				lv[i] = 4;
			} else if (happy[i] >= 30 && reliance[i] >= 30 && healthy[i] >= 30 && clean[i] >= 30) {
				lv[i] = 3;
			} else if (happy[i] >= 10 && reliance[i] >= 10 && healthy[i] >= 10 && clean[i] >= 10) {
				lv[i] = 2;
			} else {
				lv[i] = 1;
			}
		}

		
		while (num != 9) {
			// 자리 잘 찾아가는지 임시로 확인!
//			System.out.println(Arrays.toString(id));
//			System.out.println(Arrays.toString(pass));

			System.out.print("  /|_/|   From Stray\n" + "_( o.o )__To Home___♡♡\n" + "=========================" +

					"\n0. 로그인" + "\n1. 보호자 등록" + "\n2. 고양이 상태 조회" + "\n3. 고양이 돌보기" + "\n4. 환경 개선" + "\n5. 병원 방문"
					+ "\n6. 고양이 돌보는 방법" + "\n7. 고양이 보내기" + "\n9. 오늘 활동 종료 ");
			System.out.print("\n▶활동을 선택해 주세요 : ");
			num = scanner.nextInt();

			// ■기능 2.
			if (num == 9) {
				System.out.println("오늘의 돌봄을 종료합니다.");
				break;
			}

			else if (num == 0) {

				System.out.print("ID : ");
				tempid = scanner.next();
				System.out.print("비밀번호 : ");
				temppass = scanner.next();

				if (id[i] == null && pass[i] == null) {
					System.out.println("등록되지 않은 보호자입니다\n보호자로 등록해주세요");
				}

				else if (tempid.equals(id[i]) && temppass.equals(pass[i])) {
					System.out.println("보호자 정보가 일치합니다");
					login = true;
				}

				else if (!(id[i] == null && pass[i] == null || tempid.equals(id[i]) && temppass.equals(pass[i]))) {
					System.out.println("ID와 비밀번호를 확인해 주세요");
					continue;
				}

			} else if (num == 1) {

				// 사용자 i와 별개로 단순 빈자리 확인용이라 아무 변수 넣어도 ㄱㅊㄱㅊ!
				// 오히려 i 넣으면 헷갈릴수 있음

				int find = -1;
				for (int k = 0; k < id.length; k++) {
					if (id[k] == null) {
						find = k;
						break;
					}
				}

				System.out.println("보호자 등록을 시작합니다");
				System.out.print("ID를 생성해 주세요 : ");
				id[i] = scanner.next();
				System.out.print("비밀번호를 생성해 주세요 : ");
				pass[i] = scanner.next();
				System.out.println("보호자 정보가 등록되었습니다");

				System.out.println("돌봄이 필요한 고양이의 정보를 등록해 주세요");
				System.out.print("이름 : ");
				catname[i] = scanner.next();
				System.out.print("나이 : ");
				age[i] = scanner.nextInt();
				System.out.print("종 : ");
				kind[i] = scanner.next();
				System.out.print("특징 : ");
				point[i] = scanner.next();

				// 디폴트null로 출력 방지용
				bowl[find] = "기본 식기";
				toy[find] = "초급 장난감 세트";
				bath[find] = "기본 화장실";
				tower[find] = "기본 캣타워";
				hide[find] = "기본 은신처";

			}

			else if (login == false && (num == 2 || num == 3 || num == 4 || num == 5 || num == 6 || num == 7)) {
				System.out.println("로그인을 해주세요");
			}

			else if (login == true && (num == 2 || num == 3 || num == 4 || num == 5 || num == 6 || num == 7)) {

				// ■1. 사용자 인증
				// 2. 2,3,4,5 각각에 해당하는 처리
				switch (num) {
				case 2:
					System.out.printf("보호자 : %s\n이름 : %s\n나이 : %d\n종 : %s\n특징 : %s\n", id[i], catname[i], age[i],
							kind[i], point[i]);
					System.out.printf("행복 : %dpoint\n신뢰 : %dpoint\n건강 : %dpoint\n위생 : %dpoint\n보너스 : %dpoint\n",
							happy[i], reliance[i], healthy[i], clean[i], bonus[i]);
					System.out.printf("%s은/는 현재 %s, %s, \n%s, %s, %s를 사용하고 있습니다\n", catname[i], bowl[i], toy[i],
							tower[i], hide[i], bath[i]);
					switch (lv[i]) {
					case 1:
						System.out.println(catname[i] + "은/는 [EMERGENCY] 단계입니다\n응급 상황에 주의해 주세요");
						break;
					case 2:
						System.out.println(catname[i] + "은/는 [NEED CARE] 단계입니다\n위기는 넘겼지만 세심한 관찰이 필요합니다");
						break;
					case 3:
						System.out.println(catname[i] + "은/는 [STABLE] 단계입니다\n완벽한 집고양이로 거듭나는 중입니다");
						break;
					case 4:
						System.out.println(catname[i] + "은/는 [READY TO ADOPT] 단계입니다\n새로운 삶을 시작할 준비가 되었습니다");
						break;
					case 5:
						System.out.println(catname[i] + "은/는 보호자님과 행복한 시간을 보내고 있습니다");
						break;
					case 6:
						System.out.println(catname[i] + "은/는 새로운 가족이 생겨 행복합니다");
						break;
					case 7:
						System.out.println(catname[i] + "은/는 보호소에서 가족을 기다리고 있습니다");
						break;
					}

					break;

				case 3:
					if (lv[i] == 7) {
						System.out.println("임시 보호가 종료되었습니다");
					} else {
						System.out.println("1.식사(행복+10 건강+3 보너스+10)\n" + "2.간식(행복+5 신뢰+5 건강-3 보너스+7)\n"
								+ "3.놀아주기(행복+5 신뢰+5 건강5+ 보너스+15)\n" + "4.쓰다듬기(행복+3 신뢰+3 보너스+5)\n"
								+ "5.같이 낮잠 자기(행복+5 신뢰+10 보너스+10)\n" + "6.화장실 청소(위생+3 보너스+10)\n"
								+ "7.빗질(행복+3 신뢰+3 위생+10 보너스+10)\n" + "8.양치(행복-5 신뢰-5 건강+10 위생+10 보너스+20\n"
								+ "9.다른 활동을 한다");
						System.out.print("▶돌봄을 선택해 주세요: ");

						int j = scanner.nextInt();

						if (lv[i] < 5) {
							if (happy[i] >= 50 && reliance[i] >= 50 && healthy[i] >= 50 && clean[i] >= 50) {
								lv[i] = 4;
							} else if (happy[i] >= 30 && reliance[i] >= 30 && healthy[i] >= 30 && clean[i] >= 30) {
								lv[i] = 3;
							} else if (happy[i] >= 10 && reliance[i] >= 10 && healthy[i] >= 10 && clean[i] >= 10) {
								lv[i] = 2;
							} else {
								lv[i] = 1;
							}
						}

						switch (j) {
						case 1:
							System.out.println("사료를 주었습니다\n" + catname[i] + "이/가 만족스러워하며 다리에 비비고 지나갑니다");
							happy[i] += 5;
							healthy[i] += 3;
							bonus[i] += 10;
							break;
						case 2:
							System.out.println("간식을 주었습니다\n" + catname[i] + "이/가 신나서 우다다를 시작했습니다");
							happy[i] += 5;
							reliance[i] += 5;
							healthy[i] -= 3;
							bonus[i] += 7;
							break;

						case 3:
							System.out.println("장난감으로 놀아주었습니다\n" + catname[i] + "은/는 오늘 새벽에 깨지 않고 푹 잘것입니다");
							happy[i] += 5;
							reliance[i] += 5;
							healthy[i] += 5;
							bonus[i] += 15;
							break;

						case 4:
							System.out.println("부드럽게 쓰다듬었습니다\n" + catname[i] + "이 골골송을 부릅니다");
							happy[i] += 3;
							reliance[i] += 3;
							bonus[i] += 5;
							break;
						case 5:
							System.out.println(catname + "가 옆구리에 기대어 누웠습니다\n체온이 따뜻합니다");
							happy[i] += 5;
							reliance[i] += 10;
							bonus[i] += 10;
							break;
						case 6:
							System.out.println("화장실을 깨끗하게 청소했습니다\n" + catname[i] + "의 감자는 양호합니다");
							healthy[i] += 3;
							clean[i] += 10;
							bonus[i] += 15;
							break;
						case 7:
							System.out.println("엉킨 털을 빗어주었습니다\n" + catname[i] + "에게 털공을 만들어 주었습니다");
							happy[i] += 3;
							reliance[i] += 3;
							clean[i] += 10;
							bonus[i] += 10;
							break;
						case 8:
							System.out
									.println("당신은 혈투 끝에 겨우 양치를 마쳤습니다\n" + catname[i] + "은/는 오늘 캣타워 꼭대기에서 내려오지 않을 것입니다");
							happy[i] -= 5;
							reliance[i] -= 5;
							healthy[i] += 10;
							clean[i] += 10;
							bonus[i] += 20;
							break;
						}

						if (lv[i] < 5) {
							if (happy[i] >= 50 && reliance[i] >= 50 && healthy[i] >= 50 && clean[i] >= 50) {
								lv[i] = 4;
							} else if (happy[i] >= 30 && reliance[i] >= 30 && healthy[i] >= 30 && clean[i] >= 30) {
								lv[i] = 3;
							} else if (happy[i] >= 10 && reliance[i] >= 10 && healthy[i] >= 10 && clean[i] >= 10) {
								lv[i] = 2;
							} else {
								lv[i] = 1;
							}
						}

					}
					break;

				case 4:
					if (lv[i] == 7) {
						System.out.println("임시 보호가 종료되었습니다");
					} else {
						System.out.println("보너스 포인트로 더 나은 환경을 제공하세요");
						System.out.println("1. 보통 식기와 투명 물그릇(건강+10) -20point" + "\n2. 고급 식기와 정수기(건강+20) -40point"
								+ "\n3. 중급 장난감 세트(행복+10) -20point" + "\n4. 고급 장난감 세트(행복+20) -40point"
								+ "\n5. 중형 화장실(위생+10) -20point" + "\n6. 대형 화장실(위생+20) -40point"
								+ "\n7. 평범한 은신처(신뢰+10) -20point" + "\n8. 안락한 은신처(신뢰+20) -40point"
								+ "\n9. 원목 캣타워(모든 항목+10) -50point" + "\n10. 디자인 가구 캣타워(모든 항목+20) -100point");
						System.out.print("보유 포인트 : " + bonus[i] + "\n구매하시겠습니까?(Y/N)");
						yn = scanner.next().charAt(0);
						if (yn == 'N' || yn == 'n') {
							System.out.println("구매가 취소되었습니다");
						} else if (yn == 'Y' || yn == 'y') {
							System.out.print("번호를 선택해 주세요 : ");
							int k = scanner.nextInt();

							switch (k) {
							case 1:
								if (20 > bonus[i]) {
									System.out.println("포인트가 부족합니다");
								} else {
									System.out.println("보통 식기와 투명 물그릇을 구매했습니다");
									bowl[i] = "보통 식기와 투명 물그릇";
									bonus[i] -= 20;
									healthy[i] += 10;
								}
								break;
							case 2:
								if (40 > bonus[i]) {
									System.out.println("포인트가 부족합니다");
								} else {
									System.out.println("고급 식기와 정수기를 구매했습니다");
									bowl[i] = "고급 식기와 정수기";
									bonus[i] -= 40;
									healthy[i] += 20;
								}
								break;
							case 3:
								if (20 > bonus[i]) {
									System.out.print("포인트가 부족합니다");
								} else {
									System.out.println("중급 장난감 세트를 구매했습니다");
									toy[i] = "중급 장난감 세트";
									bonus[i] -= 20;
									happy[i] += 10;
								}
								break;
							case 4:
								if (40 > bonus[i]) {
									System.out.println("포인트가 부족합니다");
								} else {
									System.out.println("고급 장난감 세트를 구매했습니다");
									toy[i] = "고급 장난감 세트";
									bonus[i] -= 40;
									happy[i] += 20;
								}
								break;
							case 5:
								if (20 > bonus[i]) {
									System.out.println("포인트가 부족합니다");
								} else {
									System.out.println("중형 화장실을 구매했습니다");
									bath[i] = "중형 화장실";
									bonus[i] -= 20;
									clean[i] += 10;
								}
								break;
							case 6:
								if (40 > bonus[i]) {
									System.out.println("포인트가 부족합니다");
								} else {
									System.out.println("대형 화장실을 구매했습니다");
									bath[i] = "대형 화장실";
									bonus[i] -= 40;
									clean[i] += 20;
								}
								break;
							case 7:
								if (20 > bonus[i]) {
									System.out.println("포인트가 부족합니다");
								} else {
									System.out.println("평범한 은신처를 구매했습니다");
									hide[i] = "평범한 은신처";
									bonus[i] -= 20;
									reliance[i] += 10;
								}
								break;
							case 8:
								if (40 > bonus[i]) {
									System.out.println("포인트가 부족합니다");
								} else {
									System.out.println("안락한 은신처를 구매했습니다");
									hide[i] = "안락한 은신처";
									bonus[i] -= 40;
									reliance[i] += 20;
								}
								break;
							case 9:
								if (50 > bonus[i]) {
									System.out.println("포인트가 부족합니다");
								} else {
									System.out.println("원목 캣타워를 구매했습니다");
									tower[i] = "원목 캣타워";
									bonus[i] -= 50;
									healthy[i] += 10;
									happy[i] += 10;
									clean[i] += 10;
									reliance[i] += 10;
								}
								break;
							case 10:
								if (100 > bonus[i]) {
									System.out.println("포인트가 부족합니다");
								} else {
									System.out.println("디자인 가구 캣타워를 구매했습니다");
									tower[i] = "디자인 가구 캣타워";
									bonus[i] -= 100;
									healthy[i] += 20;
									happy[i] += 20;
									clean[i] += 20;
									reliance[i] += 20;
								}
								break;

							}

							if (lv[i] < 5) {
								if (happy[i] >= 50 && reliance[i] >= 50 && healthy[i] >= 50 && clean[i] >= 50) {
									lv[i] = 4;
								} else if (happy[i] >= 30 && reliance[i] >= 30 && healthy[i] >= 30 && clean[i] >= 30) {
									lv[i] = 3;
								} else if (happy[i] >= 10 && reliance[i] >= 10 && healthy[i] >= 10 && clean[i] >= 10) {
									lv[i] = 2;
								} else {
									lv[i] = 1;
								}
							}

							// case

							else {
								System.out.println("N 또는 Y를 입력해 주세요");
							}

						}

					}
					break;
				// 병원 방문 건강과 스트레스 교환
				case 5:
					if (lv[i] == 7) {
						System.out.println("임시 보호가 종료되었습니다");
					} else {
						System.out.println("동물병원에 오신 것을 환영합니다\n검진 시 고양이가 스트레스를 받을 수 있으며\n비용은 보호소에서 지원됩니다");
						System.out.print("검진을 진행하시겠습니까?(Y/N)");
						yn = scanner.next().charAt(0);
						if (yn == 'N' || yn == 'n') {
							System.out.println("검진을 취소했습니다");
						} else if (yn == 'Y' || yn == 'y') {
							System.out.println("검진을 진행합니다(보너스+10)");
							switch (lv[i]) {
							case 1:
								System.out.println("건강 상태가 좋지 않습니다\n치료를 진행합니다(건강+15 행복-3 신뢰-7)");
								healthy[i] += 15;
								happy[i] -= 3;
								reliance[i] -= 7;
								bonus[i] += 10;
								break;
							case 2:
								System.out.println("건강 상태가 개선되고 있습니다\n치료를 진행합니다(건강+10 행복-5 신뢰-5)");
								healthy[i] += 10;
								happy[i] -= 5;
								reliance[i] -= 5;
								bonus[i] += 10;
								break;
							case 3:
								System.out.println("건강 상태가 양호해졌습니다\n치료를 진행합니다(건강+5 행복-7 신뢰-3)");
								healthy[i] += 5;
								happy[i] -= 7;
								reliance[i] -= 3;
								bonus[i] += 10;
								break;
							case 4:
								System.out.println("매우 건강합니다!\n고양이가 화가 났습니다(행복-10)");
								happy[i] -= 10;
								bonus[i] += 10;
								break;
							}

							if (lv[i] < 5) {
								if (happy[i] >= 50 && reliance[i] >= 50 && healthy[i] >= 50 && clean[i] >= 50) {
									lv[i] = 4;
								} else if (happy[i] >= 30 && reliance[i] >= 30 && healthy[i] >= 30 && clean[i] >= 30) {
									lv[i] = 3;
								} else if (happy[i] >= 10 && reliance[i] >= 10 && healthy[i] >= 10 && clean[i] >= 10) {
									lv[i] = 2;
								} else {
									lv[i] = 1;
								}

							}

						}

					}

					break;

				case 6:
					System.out.println("1. 고양이 상태 안내");
					System.out.println("고양이는 획득한 포인트에 따라 4단계를 거칩니다\n" + "[EMERGENCY]\n상태 매우 나쁨!(돌봄 직후)\n"
							+ "[NEED CARE]\n지속적인 돌봄 필요\n모든 포인트 10점 이상 획득\n" + "[STABLE]\n안정된 상태\n모든 포인트 30점 이상 획득\n"
							+ "[READY TO ADOPT]\n가족을 맞이할 준비가 되었어요\n모든 포인트 50점 이상 획득\n");
					System.out.println("2. 포인트란?");
					System.out.println("고양이의 행복, 신뢰, 건강, 위생을 수치화한 것으로\n각 항목당 50포인트를 획득해야 입양 준비가 완료됩니다\n");
					System.out.println("3. 고양이는 어떻게 돌보나요?");
					System.out.println("돌봄 활동, 환경 개선, 병원 방문을 통해 포인트를 얻을 수 있으며\n일부 활동은 특정 포인트를 차감하기도 합니다.\n"
							+ "보너스 포인트를 통해 환경 개선 항목에서 물품 업그레이드가 가능합니다.");

					break;
				case 7:
					// 괄호 여닫는 위치 조심! 루프 밖으로 벗어날수 있음
					if (lv[i] >= 5) {
						System.out.println("임시 보호가 종료되었습니다");
					} else if (lv[i] == 4) {
						System.out.print("고양이를 입양 보낼 준비가 되셨습니까?\n(Y:입양을 보낸다/N:제가 입양할래요)");
						yn = scanner.next().charAt(0);
						if (yn == 'N' || yn == 'n') {
							System.out.println("가족이 되신 것을 축하합니다!");
							lv[i] = 5;
						} else if (yn == 'Y' || yn == 'y') {
							System.out.println(catname[i] + "의 행복한 묘생을 응원합니다\n수고하셨습니다");
							lv[i] = 6;
						}
					} else if (lv[i] < 4) {
						System.out.print("고양이를 보호소로 돌려보내시겠습니까(Y/N)?");
						yn = scanner.next().charAt(0);
						if (yn == 'N' || yn == 'n') {
							System.out.println(id[i] + "님의 돌봄을 응원합니다");
						} else if (yn == 'Y' || yn == 'y') {
							System.out.println(catname[i] + "는 보호소로 돌아갔습니다\n수고하셨습니다");
							lv[i] = 7;
						}
					}

					break;

				}

			} // end else if login true
			else {
				System.out.println("존재하지 않는 활동입니다");
			}
		} // end for
	}// end main
}// end class
