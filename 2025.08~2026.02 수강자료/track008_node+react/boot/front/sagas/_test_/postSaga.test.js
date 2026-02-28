//sagas.postSaga.test.js
import { runSaga } from 'redux-saga';
import api from '../../api/axios';
import {
  fetchPostsRequest, fetchPostsSuccess, fetchPostsFailure,
  fetchPostRequest, fetchPostSuccess, fetchPostFailure,
  fetchPostsPagedRequest, fetchPostsPagedSuccess, fetchPostsPagedFailure,
  fetchLikedPostsRequest, fetchLikedPostsSuccess, fetchLikedPostsFailure,
  fetchMyAndRetweetsRequest, fetchMyAndRetweetsSuccess, fetchMyAndRetweetsFailure,
  createPostRequest, createPostSuccess, createPostFailure,
  updatePostRequest, updatePostSuccess, updatePostFailure,
  deletePostRequest, deletePostSuccess, deletePostFailure,
} from '../../reducers/postReducer';  //전역 상태 - 액션
import {
  fetchPosts, fetchPost, fetchPostsPaged, fetchLikedPosts,
  fetchMyAndRetweets,
  createPost, updatePost, deletePost,
} from '../postSaga';  //글쓰기 관련 액션

// axios 모킹
jest.mock('../../api/axios');

describe('post saga', () => {
  afterEach(() => {
    jest.clearAllMocks();
  }); 

  // --- 전체조회 ---
  it('fetchPostsSuccess', async()=>{
    api.get.mockResolvedValue({data:[{id:1}]});  // 서버에서 받아오는 값 - 덤프
    const dispatched=[];

    const action = fetchPostsRequest();  // react -view

    await runSaga(
        {dispatch: (a)=>{dispatched.push(a)}},
        fetchPosts,
        action
    ).toPromise();
    expect(dispatched).toContainEqual(fetchPostsSuccess([{id:1}]));
  });  

    it('fetchPostsFailure', async()=>{
    api.get.mockRejectedValue({message:'fail'});
//    api.post.mockRejectedValue(new Error('fail'));
    const dispatched=[];
    const action = fetchPostsRequest(); 
    await runSaga(
        {dispatch: (a)=>{dispatched.push(a)}},
        fetchPosts,
        action
    ).toPromise();
    expect(dispatched).toContainEqual(fetchPostsFailure('fail'));
  });  


  // --- 단건조회 ---
  it('fetchPostSuccess', async()=>{
    api.get.mockResolvedValue({data:{id:1}});  // 서버에서 받아오는 값 - 덤프
    const dispatched=[];

    const action = fetchPostRequest({postId:1});  // react -view

    await runSaga(
        {dispatch: (a)=>{dispatched.push(a)}},
        fetchPost,
        action
    ).toPromise();
    expect(dispatched).toContainEqual(fetchPostSuccess({id:1}));
  });  

//페이징
  it('fetchPostsPagedSuccess', async()=>{
    api.get.mockResolvedValue({data:[{id:10}, {id:11}]});  // 서버에서 받아오는 값 - 덤프
    const dispatched=[];

    const action = fetchPostsPagedRequest({page:1, size:2});  // react -view

    await runSaga(
        {dispatch: (a)=>{dispatched.push(a)}},
        fetchPostsPaged,
        action
    ).toPromise();
    expect(dispatched).toContainEqual(fetchPostsPagedSuccess([{id:10}, {id:11}]));
  });  


//좋아요한 게시글
  it('fetchLikedPostsSuccess', async()=>{
    api.get.mockResolvedValue({data:[{id:10}, {id:11}]});  
    const dispatched=[];

    const action = fetchLikedPostsRequest({page:1, size:2}); 

    await runSaga(
        {dispatch: (a)=>{dispatched.push(a)}},
        fetchLikedPosts,
        action
    ).toPromise();
    expect(dispatched).toContainEqual(fetchLikedPostsSuccess([{id:10}, {id:11}]));
  });  

  //내글+리트윗
  it('fetchMyAndRetweetsSuccess', async()=>{
    api.get.mockResolvedValue({data:[{id:10}, {id:11}]});  
    const dispatched=[];

    const action = fetchMyAndRetweetsRequest({page:1, size:2}); 

    await runSaga(
        {dispatch: (a)=>{dispatched.push(a)}},
        fetchMyAndRetweets,
        action
    ).toPromise();
    expect(dispatched).toContainEqual(fetchMyAndRetweetsSuccess([{id:10}, {id:11}]));
  });  


    //글쓰기
  it('createPostSuccess', async()=>{
    api.post.mockResolvedValue({data:{id:10, content:'new'}});  
    const dispatched=[];

    const action = createPostRequest({dto:{content:'new'}, files:[]}); 

    await runSaga(
        {dispatch: (a)=>{dispatched.push(a)}},
        createPost,
        action
    ).toPromise();
    expect(dispatched).toContainEqual(createPostSuccess({id:10, content:'new'}));
  });  

    //수정
  it('updatePostSuccess', async()=>{
    api.put.mockResolvedValue({data:{id:10, content:'updated'}});  
    const dispatched=[];

    const action = createPostRequest({dto:{content:'updated'}, files:[]})

    await runSaga(
        {dispatch: (a)=>{dispatched.push(a)}},
        updatePost,
        action
    ).toPromise();
    expect(dispatched).toContainEqual(updatePostSuccess({id:10, content:'updated'}));
  });  
    //삭제
  it('deletePostSuccess', async()=>{
    api.delete.mockResolvedValue({});  
    const dispatched=[];

    const action = deletePostRequest({postId:10});

    await runSaga(
        {dispatch: (a)=>{dispatched.push(a)}},
        deletePost,
        action
    ).toPromise();
    expect(dispatched).toContainEqual(deletePostSuccess(10)); //reducer에 넘길 값
  });  

});
