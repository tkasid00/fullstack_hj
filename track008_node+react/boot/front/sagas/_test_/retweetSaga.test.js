//sagas.postSaga.test.js
import { runSaga } from 'redux-saga';
import api from '../../api/axios';
import {
  addRetweetRequest, addRetweetSuccess, addRetweetFailure,
  removeRetweetRequest, removeRetweetSuccess, removeRetweetFailure,
  hasRetweetedRequest, hasRetweetedSuccess, hasRetweetedFailure,
  fetchMyRetweetsRequest, fetchMyRetweetsSuccess, fetchMyRetweetsFailure,
} from '../../reducers/retweetReducer';
import { addRetweet, removeRetweet, hasRetweeted, fetchMyRetweets } from '../retweetSaga';
// axios 모킹
jest.mock('../../api/axios');

describe('post saga', () => {
  afterEach(() => {
    jest.clearAllMocks();
  }); 

  // ---  리트윗 추가 addRetweetRequest, addRetweetSuccess, addRetweetFailure, ---
  it('addRetweetSuccess', async()=>{
    api.post.mockResolvedValue({data: {originalPostId:1, retweetCount:5}});  // 서버에서 받아오는 값 - 덤프
    const dispatched=[];

    const action = addRetweetRequest({postId:0});  // react -view

    await runSaga(
        {dispatch: (a)=>{dispatched.push(a)}},
        addRetweet,
        action
    ).toPromise();
    expect(dispatched).toContainEqual(addRetweetSuccess({postId:1, retweetCount:5}));
  });  

    it('addRetweetFailure', async()=>{
    api.post.mockRejectedValue({message:'fail'});
//    api.post.mockRejectedValue(new Error('fail'));
    const dispatched=[];
    const action = addRetweetRequest({postId:0}); 
    await runSaga(
        {dispatch: (a)=>{dispatched.push(a)}},
        addRetweet,
        action
    ).toPromise();
    expect(dispatched).toContainEqual(addRetweetFailure('fail'));
  });  

// --리트윗 삭제  removeRetweetRequest, removeRetweetSuccess, removeRetweetFailure,
  it('removeRetweetSuccess', async()=>{
    api.delete.mockResolvedValue({data: {retweetCount:4}});  // 서버에서 받아오는 값 - 덤프
    const dispatched=[];

    const action = removeRetweetRequest({postId:1});  // react -view

    await runSaga(
        {dispatch: (a)=>{dispatched.push(a)}},
        removeRetweet,
        action
    ).toPromise();
    expect(dispatched).toContainEqual(removeRetweetSuccess({postId:1, retweetCount:4}));
  });  



// --리트윗 여부 hasRetweetedRequest, hasRetweetedSuccess, hasRetweetedFailure,
  it('hasRetweetedSuccess', async()=>{
    api.get.mockResolvedValue({data:true});  //그냥 이렇게 던짐
    const dispatched=[];

    const action = hasRetweetedRequest({postId:1});  // react -view

    await runSaga(
        {dispatch: (a)=>{dispatched.push(a)}},
        hasRetweeted,
        action
    ).toPromise();
    expect(dispatched).toContainEqual(hasRetweetedSuccess({postId:1, hasRetweeted:true}));
  });  

// --내 리트윗 글  fetchMyRetweetsRequest, fetchMyRetweetsSuccess, fetchMyRetweetsFailure,
  it('fetchMyRetweetsSuccess', async()=>{
    api.get.mockResolvedValue({data:[1,2,3]}); 
    const dispatched=[];

    const action = fetchMyRetweetsRequest({userId:1});  // react -view

    await runSaga(
        {dispatch: (a)=>{dispatched.push(a)}},
        fetchMyRetweets,
        action
    ).toPromise();
    expect(dispatched).toContainEqual(fetchMyRetweetsSuccess({1:true, 2:true, 3:true}));
  });  

});
