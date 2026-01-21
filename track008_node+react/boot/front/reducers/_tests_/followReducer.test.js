import reducer, {
  followRequest, followSuccess, followFailure,
  unfollowRequest, unfollowSuccess, unfollowFailure,
  loadFollowersRequest, loadFollowersSuccess, loadFollowersFailure,
  loadFollowingsRequest, loadFollowingsSuccess, loadFollowingsFailure, 
  toggleFollowRequest,
} from '../followReducer'

describe('follow reducer', ()=>{
const initialState = {
  followersMap: {}, followingsMap: {}, followersList: [],  followingsList: [], loading: false, error: null,};
    //팔로우
    it(('followSuccess'), ()=>{
        const state =reducer(initialState, followSuccess({followeeId:1}));
        expect(state.followingsMap["1"]).toBe(true);
        expect(state.followingsList[0].followeeId).toBe("1");
    });

    //언팔
    it(('unfollowSuccess'), ()=>{
        const prev = {...initialState, followingsMap:{"1":true}, followingsList:[{followeeId:"1"}]};
        const state =reducer(prev, unfollowSuccess(1));
        expect(state.followingsMap["1"]).toBeUndefined();
        expect(state.followingsList.length).toBe(0);
    });   
    
    //팔로워들
    it(('loadFollowersSuccess'), ()=>{
        const state =reducer(initialState, loadFollowersSuccess([{followerId:1}]));
        expect(state.followersMap["1"]).toBe(true);
        expect(state.followersList.length).toBe(1);
    });   


    //팔로잉들
    it(('loadFollowingsSuccess'), ()=>{
        const state =reducer(initialState, loadFollowingsSuccess([{followeeId:1}]));
        expect(state.followingsMap["1"]).toBe(true);
        expect(state.followingsList.length).toBe(1);
        expect(state.followingsList[0].followeeId).toBe("1");
    });   


    //토글
    it(('toggleFollowRequest'), ()=>{
        const state =reducer(initialState, toggleFollowRequest());
        expect(state.error).toBeNull();
    });   

});