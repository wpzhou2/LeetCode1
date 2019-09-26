package LeetCode;

import java.util.ArrayList;

/**
 * @Author: weipeng
 * @Date: 2019/5/26  10:20
 * @Description:
 **/
public class LC_207_CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

        for(int i=0;i<numCourses;i++)
            graph.add(new ArrayList<Integer>());

        for(int i=0;i<prerequisites.length;i++)
        {
            int course = prerequisites[i][0];
            int pcourse = prerequisites[i][1];
            graph.get(course).add(pcourse);
        }

        int[] visited = new int[numCourses];
        for(int i=0;i<numCourses;i++)
            if(DFS(i,graph,visited))
                return false;
        return true;
    }

    public boolean DFS(int curr, ArrayList<ArrayList<Integer>> graph, int[] visited)
    {
        //�ݹ��������
        if(visited[curr]==1)//����ڵ��Ѿ�������
            return true;
        if(visited[curr]==2)//����ڵ�û�б�����
            return false;

        //ҵ���߼�����
        visited[curr]=1;//��ʾ���ڷ���
        for(int id:graph.get(curr))
            if(DFS(id,graph,visited))
                return true;
        visited[curr]=2;//��ʾ�Ѿ�����
        return false;
    }
}
