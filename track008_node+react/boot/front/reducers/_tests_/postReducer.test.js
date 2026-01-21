import reducer, {
  fetchPostsRequest, fetchPostsSuccess, fetchPostsFailure,
  fetchPostRequest, fetchPostSuccess, fetchPostFailure,
  fetchPostsPagedRequest, fetchPostsPagedSuccess, fetchPostsPagedFailure,
  fetchLikedPostsRequest, fetchLikedPostsSuccess, fetchLikedPostsFailure,
  fetchMyAndRetweetsRequest, fetchMyAndRetweetsSuccess, fetchMyAndRetweetsFailure,
  createPostRequest, createPostSuccess, createPostFailure,
  updatePostRequest, updatePostSuccess, updatePostFailure,
  deletePostRequest, deletePostSuccess, deletePostFailure,
} from '../postReducer'

describe('like reducer', ()=>{
   const initialState = { posts: [], likedPosts: [], currentPost: null,      
  myAndRetweets: [],    loading: false,     error: null,       };

    //글들
    it(('fetchPostsSuccess'), ()=>{
        const posts = [{ id: 1 }];
        const state =reducer(initialState, fetchPostsSuccess(posts));
        expect(state.posts).toEqual(posts);
    });

    //글
    it(('fetchPostSuccess'), ()=>{
        const post = { id: 1 };
        const state =reducer(initialState, fetchPostSuccess(post));
        expect(state.currentPost).toEqual(post);  //currentPost 주의!
    });


    //페이징
    it(('fetchPostsPagedSuccess'), ()=>{
        const posts = [{ id: 10 }, { id: 11 }];
        const state =reducer(initialState, fetchPostsPagedSuccess(posts));
        expect(state.posts).toEqual(posts);
    });

    //좋아요한 글
    it(('fetchLikedPostsSuccess'), ()=>{
        const likedPosts = [{ id: 10 }, { id: 11 }];
        const state =reducer(initialState, fetchLikedPostsSuccess(likedPosts));
        expect(state.likedPosts).toEqual(likedPosts);
    });

    //리트윗한글
    it(('fetchMyAndRetweetsSuccess'), ()=>{
        const myAndRetweets = [{ id: 10 }, { id: 11 }];
        const state =reducer(initialState, fetchMyAndRetweetsSuccess(myAndRetweets));
        expect(state.myAndRetweets).toEqual(myAndRetweets);
    });

    //글 작성
    it('handles createPostSuccess', () => {
        const post = { id: 2 };
        const state = reducer(initialState, createPostSuccess(post));
        expect(state.posts[0]).toEqual(post);  //[0] 배열로 꺼내기!
    });

    //수정
    it(('updatePostSuccess'), ()=>{
            const prev = { ...initialState, posts: [{ id: 1, title: 'old' }], 
                                            currentPost: { id: 1, title: 'old' } };  //currentPost 받아와야됨!
        const update={ id: 1, title: 'new' }
        const state =reducer(prev, updatePostSuccess(update));
        expect(state.posts[0].title).toBe('new');    //posts에서 바뀐 값 비교하고
        expect(state.currentPost).toEqual(update);  //여기서 글 자체 비교하기
    });
    
    //삭제
    // it(('deletePostSuccess'), ()=>{
    //     const prev ={...initialState, posts:{id:1}};
    //     const state =reducer(prev, deletePostSuccess(1));   //단순하게 아이디만 써도 됨
    //     expect(state.posts.length).toBe(0);  

    // });

    it('handles deletePostSuccess', () => {
        const prev = { ...initialState, posts: [{ id: 1 }, { id: 2 }] };
        const state = reducer(prev, deletePostSuccess(1));
        expect(state.posts).toEqual([{ id: 2 }]);
    });


});